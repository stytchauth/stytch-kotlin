package com.stytch.kotlin.http

import com.squareup.moshi.Moshi
import com.stytch.kotlin.common.ErrorResponse
import com.stytch.kotlin.common.SDK_NAME
import com.stytch.kotlin.common.StytchException
import com.stytch.kotlin.common.StytchResult
import okhttp3.Credentials
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.util.concurrent.TimeUnit

private const val ONE_HUNDRED_TWENTY = 120L

internal class HttpClient(
    private val baseUrl: String,
    projectId: String,
    secret: String,
) {
    private val credentials = Credentials.basic(username = projectId, password = secret)
    private val moshi = Moshi.Builder().build()
    private val client = OkHttpClient.Builder()
        .readTimeout(ONE_HUNDRED_TWENTY, TimeUnit.SECONDS)
        .writeTimeout(ONE_HUNDRED_TWENTY, TimeUnit.SECONDS)
        .connectTimeout(ONE_HUNDRED_TWENTY, TimeUnit.SECONDS)
        .addNetworkInterceptor {
            it.proceed(
                it.request()
                    .newBuilder()
                    // OkHttp is adding a charset to the content-type which is rejected by the API
                    // see: https://github.com/square/okhttp/issues/3081
                    .header("Content-Type", "application/json")
                    .header("User-Agent", SDK_NAME)
                    .header("Authorization", credentials)
                    .build(),
            )
        }
        .build()

    private fun buildUrl(path: String, params: Map<String, Any> = emptyMap()): HttpUrl =
        "$baseUrl$path".toHttpUrl().newBuilder().apply {
            params.forEach { (key, value) ->
                addQueryParameter(key, value.toString())
            }
        }.build()

    private inline fun <reified T> mapResponseToClass(response: Response, clazz: Class<T>): T? =
        response.body?.let {
            moshi.adapter(clazz).fromJson(it.source())
        }

    private inline fun <reified T> makeRequest(request: Request, clazz: Class<T>): StytchResult<T> {
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                return StytchResult.Error(
                    mapResponseToClass(response, ErrorResponse::class.java)?.let {
                        StytchException.Response(it)
                    } ?: StytchException.Critical(
                        reason = IllegalStateException("Unable to map error data"),
                        response = response.body?.source()?.readUtf8(),
                    ),
                )
            }
            return mapResponseToClass(response, clazz)?.let {
                StytchResult.Success(it)
            } ?: StytchResult.Error(
                StytchException.Critical(
                    reason = IllegalStateException("Unable to map response data"),
                    response = response.body?.source()?.readUtf8(),
                ),
            )
        }
    }

    inline fun <reified T> get(path: String, params: Map<String, Any> = emptyMap()): StytchResult<T> {
        val request = Request.Builder()
            .url(buildUrl(path, params))
            .build()
        return makeRequest(request, T::class.java)
    }

    inline fun <reified T> post(path: String, json: String): StytchResult<T> {
        val request = Request.Builder()
            .url(buildUrl(path))
            .post(json.toRequestBody("application/json".toMediaType()))
            .build()
        return makeRequest(request, T::class.java)
    }

    inline fun <reified T> put(path: String, json: String): StytchResult<T> {
        val request = Request.Builder()
            .url(buildUrl(path))
            .put(json.toRequestBody("application/json".toMediaType()))
            .build()
        return makeRequest(request, T::class.java)
    }

    inline fun <reified T> delete(path: String, params: Map<String, Any> = emptyMap()): StytchResult<T> {
        val request = Request.Builder()
            .url(buildUrl(path, params))
            .delete()
            .build()
        return makeRequest(request, T::class.java)
    }
}

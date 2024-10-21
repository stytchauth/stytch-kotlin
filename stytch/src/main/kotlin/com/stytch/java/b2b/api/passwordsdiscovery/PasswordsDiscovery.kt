package com.stytch.java.b2b.api.passwordsdiscovery

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.b2b.api.passwordsdiscoveryemail.Email
import com.stytch.java.b2b.api.passwordsdiscoveryemail.EmailImpl
import com.stytch.java.b2b.models.passwordsdiscovery.AuthenticateRequest
import com.stytch.java.b2b.models.passwordsdiscovery.AuthenticateResponse
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.StytchResult
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture

public interface Discovery {
    public val email: Email

    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    public fun authenticate(
        data: AuthenticateRequest,
        callback: (StytchResult<AuthenticateResponse>) -> Unit,
    )

    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>
}

internal class DiscoveryImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Discovery {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override val email: Email = EmailImpl(httpClient, coroutineScope)

    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/passwords/discovery/authenticate", asJson, headers)
        }

    override fun authenticate(
        data: AuthenticateRequest,
        callback: (StytchResult<AuthenticateResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(authenticate(data))
        }
    }

    override fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>> =
        coroutineScope.async {
            authenticate(data)
        }.asCompletableFuture()
}

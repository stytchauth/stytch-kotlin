package com.stytch.kotlin.b2b.api.otpsms

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.kotlin.b2b.models.otpsms.AuthenticateRequest
import com.stytch.kotlin.b2b.models.otpsms.AuthenticateResponse
import com.stytch.kotlin.b2b.models.otpsms.SendRequest
import com.stytch.kotlin.b2b.models.otpsms.SendResponse
import com.stytch.kotlin.common.StytchResult
import com.stytch.kotlin.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
public interface Sms {
    public suspend fun send(data: SendRequest): StytchResult<SendResponse>

    public fun send(data: SendRequest, callback: (StytchResult<SendResponse>) -> Unit)

    public fun sendCompletable(data: SendRequest): CompletableFuture<StytchResult<SendResponse>>

    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)

    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>
}

internal class SmsImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Sms {

    private val moshi = Moshi.Builder().build()

    override suspend fun send(data: SendRequest): StytchResult<SendResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(SendRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/otps/sms/send", asJson)
    }

    override fun send(data: SendRequest, callback: (StytchResult<SendResponse>) -> Unit) {
        coroutineScope.launch {
            callback(send(data))
        }
    }

    override fun sendCompletable(data: SendRequest): CompletableFuture<StytchResult<SendResponse>> =
        coroutineScope.async {
            send(data)
        }.asCompletableFuture()
    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/otps/sms/authenticate", asJson)
    }

    override fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(authenticate(data))
        }
    }

    override fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>> =
        coroutineScope.async {
            authenticate(data)
        }.asCompletableFuture()
}

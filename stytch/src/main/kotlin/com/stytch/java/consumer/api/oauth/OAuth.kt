package com.stytch.java.consumer.api.oauth

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.StytchResult
import com.stytch.java.consumer.models.oauth.AttachRequest
import com.stytch.java.consumer.models.oauth.AttachResponse
import com.stytch.java.consumer.models.oauth.AuthenticateRequest
import com.stytch.java.consumer.models.oauth.AuthenticateResponse
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
public interface OAuth {
    /**
     * Generate an OAuth Attach Token to pre-associate an OAuth flow with an existing Stytch User. Pass the returned
     * `oauth_attach_token` to the same provider's OAuth Start endpoint to treat this OAuth flow as a login for that user
     * instead of a signup for a new user.
     *
     * Exactly one of `user_id`, `session_token`, or `session_jwt` must be provided to identify the target Stytch User.
     *
     * This is an optional step in the OAuth flow. Stytch can often determine whether to create a new user or log in an
     * existing one based on verified identity provider information. This endpoint is useful for cases where we can't, such as
     * missing or unverified provider information.
     */
    public suspend fun attach(data: AttachRequest): StytchResult<AttachResponse>

    /**
     * Generate an OAuth Attach Token to pre-associate an OAuth flow with an existing Stytch User. Pass the returned
     * `oauth_attach_token` to the same provider's OAuth Start endpoint to treat this OAuth flow as a login for that user
     * instead of a signup for a new user.
     *
     * Exactly one of `user_id`, `session_token`, or `session_jwt` must be provided to identify the target Stytch User.
     *
     * This is an optional step in the OAuth flow. Stytch can often determine whether to create a new user or log in an
     * existing one based on verified identity provider information. This endpoint is useful for cases where we can't, such as
     * missing or unverified provider information.
     */
    public fun attach(data: AttachRequest, callback: (StytchResult<AttachResponse>) -> Unit)

    /**
     * Generate an OAuth Attach Token to pre-associate an OAuth flow with an existing Stytch User. Pass the returned
     * `oauth_attach_token` to the same provider's OAuth Start endpoint to treat this OAuth flow as a login for that user
     * instead of a signup for a new user.
     *
     * Exactly one of `user_id`, `session_token`, or `session_jwt` must be provided to identify the target Stytch User.
     *
     * This is an optional step in the OAuth flow. Stytch can often determine whether to create a new user or log in an
     * existing one based on verified identity provider information. This endpoint is useful for cases where we can't, such as
     * missing or unverified provider information.
     */
    public fun attachCompletable(data: AttachRequest): CompletableFuture<StytchResult<AttachResponse>>

    /**
     * Authenticate a User given a `token`. This endpoint verifies that the user completed the OAuth flow by verifying that
     * the token is valid and hasn't expired. To initiate a Stytch session for the user while authenticating their OAuth
     * token, include `session_duration_minutes`; a session with the identity provider, e.g. Google or Facebook, will always
     * be initiated upon successful authentication.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Authenticate a User given a `token`. This endpoint verifies that the user completed the OAuth flow by verifying that
     * the token is valid and hasn't expired. To initiate a Stytch session for the user while authenticating their OAuth
     * token, include `session_duration_minutes`; a session with the identity provider, e.g. Google or Facebook, will always
     * be initiated upon successful authentication.
     */
    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)

    /**
     * Authenticate a User given a `token`. This endpoint verifies that the user completed the OAuth flow by verifying that
     * the token is valid and hasn't expired. To initiate a Stytch session for the user while authenticating their OAuth
     * token, include `session_duration_minutes`; a session with the identity provider, e.g. Google or Facebook, will always
     * be initiated upon successful authentication.
     */
    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>
}

internal class OAuthImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : OAuth {

    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun attach(data: AttachRequest): StytchResult<AttachResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AttachRequest::class.java).toJson(data)
        httpClient.post("/v1/oauth/attach", asJson)
    }

    override fun attach(data: AttachRequest, callback: (StytchResult<AttachResponse>) -> Unit) {
        coroutineScope.launch {
            callback(attach(data))
        }
    }

    override fun attachCompletable(data: AttachRequest): CompletableFuture<StytchResult<AttachResponse>> =
        coroutineScope.async {
            attach(data)
        }.asCompletableFuture()
    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/oauth/authenticate", asJson)
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

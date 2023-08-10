package com.stytch.java.b2b.api.oauth

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.b2b.api.oauthdiscovery.Discovery
import com.stytch.java.b2b.api.oauthdiscovery.DiscoveryImpl
import com.stytch.java.b2b.models.oauth.AuthenticateRequest
import com.stytch.java.b2b.models.oauth.AuthenticateResponse
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
public interface OAuth {
    public val discovery: Discovery

    /**
     * Authenticate a Member given a `token`. This endpoint verifies that the member completed the OAuth flow by verifying
     * that the token is valid and hasn't expired.  Provide the `session_duration_minutes` parameter to set the lifetime of
     * the session. If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60
     * minute duration.
     *
     * (Coming Soon) If the Member is required to complete MFA to log in to the Organization, the returned value of
     * `member_authenticated` will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `intermediate_session_token` can also be used with the
     * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) or the
     * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to join
     * a different Organization or create a new one.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Authenticate a Member given a `token`. This endpoint verifies that the member completed the OAuth flow by verifying
     * that the token is valid and hasn't expired.  Provide the `session_duration_minutes` parameter to set the lifetime of
     * the session. If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60
     * minute duration.
     *
     * (Coming Soon) If the Member is required to complete MFA to log in to the Organization, the returned value of
     * `member_authenticated` will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `intermediate_session_token` can also be used with the
     * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) or the
     * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to join
     * a different Organization or create a new one.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     */
    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)

    /**
     * Authenticate a Member given a `token`. This endpoint verifies that the member completed the OAuth flow by verifying
     * that the token is valid and hasn't expired.  Provide the `session_duration_minutes` parameter to set the lifetime of
     * the session. If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60
     * minute duration.
     *
     * (Coming Soon) If the Member is required to complete MFA to log in to the Organization, the returned value of
     * `member_authenticated` will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `intermediate_session_token` can also be used with the
     * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) or the
     * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to join
     * a different Organization or create a new one.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     */
    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>
}

internal class OAuthImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : OAuth {

    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override val discovery: Discovery = DiscoveryImpl(httpClient, coroutineScope)

    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/oauth/authenticate", asJson)
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

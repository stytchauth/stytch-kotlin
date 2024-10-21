package com.stytch.java.b2b.api.passwordsemail

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.b2b.models.passwordsemail.RequireResetRequest
import com.stytch.java.b2b.models.passwordsemail.RequireResetRequestOptions
import com.stytch.java.b2b.models.passwordsemail.RequireResetResponse
import com.stytch.java.b2b.models.passwordsemail.ResetRequest
import com.stytch.java.b2b.models.passwordsemail.ResetResponse
import com.stytch.java.b2b.models.passwordsemail.ResetStartRequest
import com.stytch.java.b2b.models.passwordsemail.ResetStartResponse
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

public interface Email {
    /**
     * Initiates a password reset for the email address provided. This will trigger an email to be sent to the address,
     * containing a magic link that will allow them to set a new password and authenticate.
     *
     * This endpoint adapts to your Project's password strength configuration.
     * If you're using [zxcvbn](https://stytch.com/docs/guides/passwords/strength-policy), the default, your passwords are
     * considered valid
     * if the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/guides/passwords/strength-policy), your
     * passwords are
     * considered valid if they meet the requirements that you've set with Stytch.
     * You may update your password strength configuration in the
     * [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     */
    public suspend fun resetStart(data: ResetStartRequest): StytchResult<ResetStartResponse>

    /**
     * Initiates a password reset for the email address provided. This will trigger an email to be sent to the address,
     * containing a magic link that will allow them to set a new password and authenticate.
     *
     * This endpoint adapts to your Project's password strength configuration.
     * If you're using [zxcvbn](https://stytch.com/docs/guides/passwords/strength-policy), the default, your passwords are
     * considered valid
     * if the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/guides/passwords/strength-policy), your
     * passwords are
     * considered valid if they meet the requirements that you've set with Stytch.
     * You may update your password strength configuration in the
     * [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     */
    public fun resetStart(
        data: ResetStartRequest,
        callback: (StytchResult<ResetStartResponse>) -> Unit,
    )

    /**
     * Initiates a password reset for the email address provided. This will trigger an email to be sent to the address,
     * containing a magic link that will allow them to set a new password and authenticate.
     *
     * This endpoint adapts to your Project's password strength configuration.
     * If you're using [zxcvbn](https://stytch.com/docs/guides/passwords/strength-policy), the default, your passwords are
     * considered valid
     * if the strength score is >= 3. If you're using [LUDS](https://stytch.com/docs/guides/passwords/strength-policy), your
     * passwords are
     * considered valid if they meet the requirements that you've set with Stytch.
     * You may update your password strength configuration in the
     * [stytch dashboard](https://stytch.com/dashboard/password-strength-config).
     */
    public fun resetStartCompletable(data: ResetStartRequest): CompletableFuture<StytchResult<ResetStartResponse>>

    /**
     * Reset the's password and authenticate them. This endpoint checks that the password reset token is valid, hasn’t
     * expired, or already been used.
     *
     * The provided password needs to meet our password strength requirements, which can be checked in advance with the
     * password strength endpoint. If the token and password are accepted, the password is securely stored for future
     * authentication and the user is authenticated.
     *
     * If the Member is required to complete MFA to log in to the Organization, the returned value of `member_authenticated`
     * will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     *
     * Note that a successful password reset by email will revoke all active sessions for the `member_id`.
     */
    public suspend fun reset(data: ResetRequest): StytchResult<ResetResponse>

    /**
     * Reset the's password and authenticate them. This endpoint checks that the password reset token is valid, hasn’t
     * expired, or already been used.
     *
     * The provided password needs to meet our password strength requirements, which can be checked in advance with the
     * password strength endpoint. If the token and password are accepted, the password is securely stored for future
     * authentication and the user is authenticated.
     *
     * If the Member is required to complete MFA to log in to the Organization, the returned value of `member_authenticated`
     * will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     *
     * Note that a successful password reset by email will revoke all active sessions for the `member_id`.
     */
    public fun reset(
        data: ResetRequest,
        callback: (StytchResult<ResetResponse>) -> Unit,
    )

    /**
     * Reset the's password and authenticate them. This endpoint checks that the password reset token is valid, hasn’t
     * expired, or already been used.
     *
     * The provided password needs to meet our password strength requirements, which can be checked in advance with the
     * password strength endpoint. If the token and password are accepted, the password is securely stored for future
     * authentication and the user is authenticated.
     *
     * If the Member is required to complete MFA to log in to the Organization, the returned value of `member_authenticated`
     * will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     *
     * If a valid `session_token` or `session_jwt` is passed in, the Member will not be required to complete an MFA step.
     *
     * Note that a successful password reset by email will revoke all active sessions for the `member_id`.
     */
    public fun resetCompletable(data: ResetRequest): CompletableFuture<StytchResult<ResetResponse>>

    public suspend fun requireReset(
        data: RequireResetRequest,
        methodOptions: RequireResetRequestOptions? = null,
    ): StytchResult<RequireResetResponse>

    public fun requireReset(
        data: RequireResetRequest,
        methodOptions: RequireResetRequestOptions? = null,
        callback: (StytchResult<RequireResetResponse>) -> Unit,
    )

    public fun requireResetCompletable(
        data: RequireResetRequest,
        methodOptions: RequireResetRequestOptions? = null,
    ): CompletableFuture<StytchResult<RequireResetResponse>>
}

internal class EmailImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Email {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun resetStart(data: ResetStartRequest): StytchResult<ResetStartResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ResetStartRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/passwords/email/reset/start", asJson, headers)
        }

    override fun resetStart(
        data: ResetStartRequest,
        callback: (StytchResult<ResetStartResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(resetStart(data))
        }
    }

    override fun resetStartCompletable(data: ResetStartRequest): CompletableFuture<StytchResult<ResetStartResponse>> =
        coroutineScope.async {
            resetStart(data)
        }.asCompletableFuture()

    override suspend fun reset(data: ResetRequest): StytchResult<ResetResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ResetRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/passwords/email/reset", asJson, headers)
        }

    override fun reset(
        data: ResetRequest,
        callback: (StytchResult<ResetResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(reset(data))
        }
    }

    override fun resetCompletable(data: ResetRequest): CompletableFuture<StytchResult<ResetResponse>> =
        coroutineScope.async {
            reset(data)
        }.asCompletableFuture()

    override suspend fun requireReset(
        data: RequireResetRequest,
        methodOptions: RequireResetRequestOptions?,
    ): StytchResult<RequireResetResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(RequireResetRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/passwords/email/require_reset", asJson, headers)
        }

    override fun requireReset(
        data: RequireResetRequest,
        methodOptions: RequireResetRequestOptions?,
        callback: (StytchResult<RequireResetResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(requireReset(data, methodOptions))
        }
    }

    override fun requireResetCompletable(
        data: RequireResetRequest,
        methodOptions: RequireResetRequestOptions?,
    ): CompletableFuture<StytchResult<RequireResetResponse>> =
        coroutineScope.async {
            requireReset(data, methodOptions)
        }.asCompletableFuture()
}

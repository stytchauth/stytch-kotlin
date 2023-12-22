package com.stytch.java.b2b.api.sessions

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.b2b.models.sessions.AuthenticateRequest
import com.stytch.java.b2b.models.sessions.AuthenticateResponse
import com.stytch.java.b2b.models.sessions.AuthorizationCheck
import com.stytch.java.b2b.models.sessions.ExchangeRequest
import com.stytch.java.b2b.models.sessions.ExchangeResponse
import com.stytch.java.b2b.models.sessions.GetJWKSRequest
import com.stytch.java.b2b.models.sessions.GetJWKSResponse
import com.stytch.java.b2b.models.sessions.GetRequest
import com.stytch.java.b2b.models.sessions.GetResponse
import com.stytch.java.b2b.models.sessions.MemberSession
import com.stytch.java.b2b.models.sessions.RevokeRequest
import com.stytch.java.b2b.models.sessions.RevokeResponse
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.JWTException
import com.stytch.java.common.JwtOptions
import com.stytch.java.common.ParseJWTClaimsOptions
import com.stytch.java.common.PolicyCache
import com.stytch.java.common.StytchB2BSessionClaim
import com.stytch.java.common.StytchException
import com.stytch.java.common.StytchResult
import com.stytch.java.common.parseJWTClaims
import com.stytch.java.consumer.models.sessions.Session
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jose4j.jwk.HttpsJwks
import java.time.Instant
import java.util.concurrent.CompletableFuture

public interface Sessions {
    /**
     * Retrieves all active Sessions for a Member.
     */
    public suspend fun get(data: GetRequest): StytchResult<GetResponse>

    /**
     * Retrieves all active Sessions for a Member.
     */
    public fun get(
        data: GetRequest,
        callback: (StytchResult<GetResponse>) -> Unit,
    )

    /**
     * Retrieves all active Sessions for a Member.
     */
    public fun getCompletable(data: GetRequest): CompletableFuture<StytchResult<GetResponse>>

    /**
     * Authenticates a Session and updates its lifetime by the specified `session_duration_minutes`. If the
     * `session_duration_minutes` is not specified, a Session will not be extended. This endpoint requires either a
     * `session_jwt` or `session_token` be included in the request. It will return an error if both are present.
     *
     * You may provide a JWT that needs to be refreshed and is expired according to its `exp` claim. A new JWT will be
     * returned if both the signature and the underlying Session are still valid.
     *
     * If an `authorization_check` object is passed in, this method will also check if the Member is authorized to perform the
     * given action on the given Resource in the specified Organization. A Member is authorized if their Member Session
     * contains a Role, assigned [explicitly or implicitly](https://github.com/docs/b2b/guides/rbac/role-assignment), with
     * adequate permissions.
     * In addition, the `organization_id` passed in the authorization check must match the Member's Organization.
     *
     * If the Member is not authorized to perform the specified action on the specified Resource, or if the
     * `organization_id` does not match the Member's Organization, a 403 error will be thrown.
     * Otherwise, the response will contain a list of Roles that satisfied the authorization check.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Authenticates a Session and updates its lifetime by the specified `session_duration_minutes`. If the
     * `session_duration_minutes` is not specified, a Session will not be extended. This endpoint requires either a
     * `session_jwt` or `session_token` be included in the request. It will return an error if both are present.
     *
     * You may provide a JWT that needs to be refreshed and is expired according to its `exp` claim. A new JWT will be
     * returned if both the signature and the underlying Session are still valid.
     *
     * If an `authorization_check` object is passed in, this method will also check if the Member is authorized to perform the
     * given action on the given Resource in the specified Organization. A Member is authorized if their Member Session
     * contains a Role, assigned [explicitly or implicitly](https://github.com/docs/b2b/guides/rbac/role-assignment), with
     * adequate permissions.
     * In addition, the `organization_id` passed in the authorization check must match the Member's Organization.
     *
     * If the Member is not authorized to perform the specified action on the specified Resource, or if the
     * `organization_id` does not match the Member's Organization, a 403 error will be thrown.
     * Otherwise, the response will contain a list of Roles that satisfied the authorization check.
     */
    public fun authenticate(
        data: AuthenticateRequest,
        callback: (StytchResult<AuthenticateResponse>) -> Unit,
    )

    /**
     * Authenticates a Session and updates its lifetime by the specified `session_duration_minutes`. If the
     * `session_duration_minutes` is not specified, a Session will not be extended. This endpoint requires either a
     * `session_jwt` or `session_token` be included in the request. It will return an error if both are present.
     *
     * You may provide a JWT that needs to be refreshed and is expired according to its `exp` claim. A new JWT will be
     * returned if both the signature and the underlying Session are still valid.
     *
     * If an `authorization_check` object is passed in, this method will also check if the Member is authorized to perform the
     * given action on the given Resource in the specified Organization. A Member is authorized if their Member Session
     * contains a Role, assigned [explicitly or implicitly](https://github.com/docs/b2b/guides/rbac/role-assignment), with
     * adequate permissions.
     * In addition, the `organization_id` passed in the authorization check must match the Member's Organization.
     *
     * If the Member is not authorized to perform the specified action on the specified Resource, or if the
     * `organization_id` does not match the Member's Organization, a 403 error will be thrown.
     * Otherwise, the response will contain a list of Roles that satisfied the authorization check.
     */
    public fun authenticateCompletable(data: AuthenticateRequest): CompletableFuture<StytchResult<AuthenticateResponse>>

    /**
     * Revoke a Session and immediately invalidate all its tokens. To revoke a specific Session, pass either the
     * `member_session_id`, `session_token`, or `session_jwt`. To revoke all Sessions for a Member, pass the `member_id`.
     */
    public suspend fun revoke(data: RevokeRequest): StytchResult<RevokeResponse>

    /**
     * Revoke a Session and immediately invalidate all its tokens. To revoke a specific Session, pass either the
     * `member_session_id`, `session_token`, or `session_jwt`. To revoke all Sessions for a Member, pass the `member_id`.
     */
    public fun revoke(
        data: RevokeRequest,
        callback: (StytchResult<RevokeResponse>) -> Unit,
    )

    /**
     * Revoke a Session and immediately invalidate all its tokens. To revoke a specific Session, pass either the
     * `member_session_id`, `session_token`, or `session_jwt`. To revoke all Sessions for a Member, pass the `member_id`.
     */
    public fun revokeCompletable(data: RevokeRequest): CompletableFuture<StytchResult<RevokeResponse>>

    /**
     * Use this endpoint to exchange a Member's existing session for another session in a different Organization. This can be
     * used to accept an invite, but not to create a new member via domain matching.
     *
     * To create a new member via domain matching, use the
     * [Exchange Intermediate Session](https://stytch.com/docs/b2b/api/exchange-intermediate-session) flow instead.
     *
     * Only Email Magic Link, OAuth, and SMS OTP factors can be transferred between sessions. Other authentication factors,
     * such as password factors, will not be transferred to the new session.
     * SMS OTP factors can be used to fulfill MFA requirements for the target Organization if both the original and target
     * Member have the same phone number and the phone number is verified for both Members.
     *
     * If the Member is required to complete MFA to log in to the Organization, the returned value of `member_authenticated`
     * will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `intermediate_session_token` can also be used with the
     * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) or the
     * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to join
     * a different Organization or create a new one.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     */
    public suspend fun exchange(data: ExchangeRequest): StytchResult<ExchangeResponse>

    /**
     * Use this endpoint to exchange a Member's existing session for another session in a different Organization. This can be
     * used to accept an invite, but not to create a new member via domain matching.
     *
     * To create a new member via domain matching, use the
     * [Exchange Intermediate Session](https://stytch.com/docs/b2b/api/exchange-intermediate-session) flow instead.
     *
     * Only Email Magic Link, OAuth, and SMS OTP factors can be transferred between sessions. Other authentication factors,
     * such as password factors, will not be transferred to the new session.
     * SMS OTP factors can be used to fulfill MFA requirements for the target Organization if both the original and target
     * Member have the same phone number and the phone number is verified for both Members.
     *
     * If the Member is required to complete MFA to log in to the Organization, the returned value of `member_authenticated`
     * will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `intermediate_session_token` can also be used with the
     * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) or the
     * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to join
     * a different Organization or create a new one.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     */
    public fun exchange(
        data: ExchangeRequest,
        callback: (StytchResult<ExchangeResponse>) -> Unit,
    )

    /**
     * Use this endpoint to exchange a Member's existing session for another session in a different Organization. This can be
     * used to accept an invite, but not to create a new member via domain matching.
     *
     * To create a new member via domain matching, use the
     * [Exchange Intermediate Session](https://stytch.com/docs/b2b/api/exchange-intermediate-session) flow instead.
     *
     * Only Email Magic Link, OAuth, and SMS OTP factors can be transferred between sessions. Other authentication factors,
     * such as password factors, will not be transferred to the new session.
     * SMS OTP factors can be used to fulfill MFA requirements for the target Organization if both the original and target
     * Member have the same phone number and the phone number is verified for both Members.
     *
     * If the Member is required to complete MFA to log in to the Organization, the returned value of `member_authenticated`
     * will be `false`, and an `intermediate_session_token` will be returned.
     * The `intermediate_session_token` can be passed into the
     * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms) to complete the MFA step and
     * acquire a full member session.
     * The `intermediate_session_token` can also be used with the
     * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) or the
     * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to join
     * a different Organization or create a new one.
     * The `session_duration_minutes` and `session_custom_claims` parameters will be ignored.
     */
    public fun exchangeCompletable(data: ExchangeRequest): CompletableFuture<StytchResult<ExchangeResponse>>

    /**
     * Get the JSON Web Key Set (JWKS) for a project.
     *
     * JWKS are rotated every ~6 months. Upon rotation, new JWTs will be signed using the new key set, and both key sets will
     * be returned by this endpoint for a period of 1 month.
     *
     * JWTs have a set lifetime of 5 minutes, so there will be a 5 minute period where some JWTs will be signed by the old
     * JWKS, and some JWTs will be signed by the new JWKS. The correct JWKS to use for validation is determined by matching
     * the `kid` value of the JWT and JWKS.
     *
     * If you're using one of our [backend SDKs](https://stytch.com/docs/b2b/sdks), the JWKS roll will be handled for you.
     *
     * If you're using your own JWT validation library, many have built-in support for JWKS rotation, and you'll just need to
     * supply this API endpoint. If not, your application should decide which JWKS to use for validation by inspecting the
     * `kid` value.
     */
    public suspend fun getJWKS(data: GetJWKSRequest): StytchResult<GetJWKSResponse>

    /**
     * Get the JSON Web Key Set (JWKS) for a project.
     *
     * JWKS are rotated every ~6 months. Upon rotation, new JWTs will be signed using the new key set, and both key sets will
     * be returned by this endpoint for a period of 1 month.
     *
     * JWTs have a set lifetime of 5 minutes, so there will be a 5 minute period where some JWTs will be signed by the old
     * JWKS, and some JWTs will be signed by the new JWKS. The correct JWKS to use for validation is determined by matching
     * the `kid` value of the JWT and JWKS.
     *
     * If you're using one of our [backend SDKs](https://stytch.com/docs/b2b/sdks), the JWKS roll will be handled for you.
     *
     * If you're using your own JWT validation library, many have built-in support for JWKS rotation, and you'll just need to
     * supply this API endpoint. If not, your application should decide which JWKS to use for validation by inspecting the
     * `kid` value.
     */
    public fun getJWKS(
        data: GetJWKSRequest,
        callback: (StytchResult<GetJWKSResponse>) -> Unit,
    )

    /**
     * Get the JSON Web Key Set (JWKS) for a project.
     *
     * JWKS are rotated every ~6 months. Upon rotation, new JWTs will be signed using the new key set, and both key sets will
     * be returned by this endpoint for a period of 1 month.
     *
     * JWTs have a set lifetime of 5 minutes, so there will be a 5 minute period where some JWTs will be signed by the old
     * JWKS, and some JWTs will be signed by the new JWKS. The correct JWKS to use for validation is determined by matching
     * the `kid` value of the JWT and JWKS.
     *
     * If you're using one of our [backend SDKs](https://stytch.com/docs/b2b/sdks), the JWKS roll will be handled for you.
     *
     * If you're using your own JWT validation library, many have built-in support for JWKS rotation, and you'll just need to
     * supply this API endpoint. If not, your application should decide which JWKS to use for validation by inspecting the
     * `kid` value.
     */
    public fun getJWKSCompletable(data: GetJWKSRequest): CompletableFuture<StytchResult<GetJWKSResponse>>

    // MANUAL(authenticateJWT_interface)(INTERFACE_METHOD)
    // ADDIMPORT: import com.stytch.java.b2b.models.sessions.AuthorizationCheck
    // ADDIMPORT: import com.stytch.java.b2b.models.sessions.MemberSession
    // ADDIMPORT: import com.stytch.java.common.JWTException
    // ADDIMPORT: import com.stytch.java.common.ParseJWTClaimsOptions
    // ADDIMPORT: import com.stytch.java.common.StytchB2BSessionClaim
    // ADDIMPORT: import com.stytch.java.common.parseJWTClaims

    /** Parse a JWT and verify the signature, preferring local verification over remote.
     *
     * If maxTokenAgeSeconds is set, remote verification will be forced if the JWT was issued at
     * (based on the "iat" claim) more than that many seconds ago.
     *
     * To force remote validation for all tokens, set maxTokenAgeSeconds to zero or use the
     * authenticate method instead.
     */
    public suspend fun authenticateJwt(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck? = null,
    ): StytchResult<MemberSession?>

    /** Parse a JWT and verify the signature, preferring local verification over remote.
     *
     * If maxTokenAgeSeconds is set, remote verification will be forced if the JWT was issued at
     * (based on the "iat" claim) more than that many seconds ago.
     *
     * To force remote validation for all tokens, set maxTokenAgeSeconds to zero or use the
     * authenticate method instead.
     */
    public fun authenticateJwt(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck? = null,
        callback: (StytchResult<MemberSession?>) -> Unit,
    )

    /** Parse a JWT and verify the signature, preferring local verification over remote.
     *
     * If maxTokenAgeSeconds is set, remote verification will be forced if the JWT was issued at
     * (based on the "iat" claim) more than that many seconds ago.
     *
     * To force remote validation for all tokens, set maxTokenAgeSeconds to zero or use the
     * authenticate method instead.
     */
    public fun authenticateJwtCompletable(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck? = null,
    ): CompletableFuture<StytchResult<MemberSession?>>

    /** Parse a JWT and verify the signature locally (without calling /authenticate in the API).
     *
     * If maxTokenAgeSeconds is set, this will return an error if the JWT was issued (based on the "iat"
     * claim) more than maxTokenAge seconds ago.
     *
     * If maxTokenAgeSeconds is explicitly set to zero, all tokens will be considered too old,
     * even if they are otherwise valid.
     *
     * The value for leeway is the maximum allowable difference when comparing
     * timestamps. It defaults to zero.
     */
    public suspend fun authenticateJwtLocal(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck? = null,
        leeway: Int = 0,
    ): StytchResult<MemberSession?>

    /** Parse a JWT and verify the signature locally (without calling /authenticate in the API).
     *
     * If maxTokenAgeSeconds is set, this will return an error if the JWT was issued (based on the "iat"
     * claim) more than maxTokenAge seconds ago.
     *
     * If maxTokenAgeSeconds is explicitly set to zero, all tokens will be considered too old,
     * even if they are otherwise valid.
     *
     * The value for leeway is the maximum allowable difference when comparing
     * timestamps. It defaults to zero.
     */
    public fun authenticateJwtLocal(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck? = null,
        leeway: Int = 0,
        callback: (StytchResult<MemberSession?>) -> Unit,
    )

    /** Parse a JWT and verify the signature locally (without calling /authenticate in the API).
     *
     * If maxTokenAgeSeconds is set, this will return an error if the JWT was issued (based on the "iat"
     * claim) more than maxTokenAge seconds ago.
     *
     * If maxTokenAgeSeconds is explicitly set to zero, all tokens will be considered too old,
     * even if they are otherwise valid.
     *
     * The value for leeway is the maximum allowable difference when comparing
     * timestamps. It defaults to zero.
     */
    public suspend fun authenticateJwtLocalCompletable(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck? = null,
        leeway: Int = 0,
    ): CompletableFuture<StytchResult<MemberSession?>>
    // ENDMANUAL(authenticateJWT_interface)
}

internal class SessionsImpl(private val httpClient: HttpClient, private val coroutineScope: CoroutineScope, private val jwksClient: HttpsJwks, private val jwtOptions: JwtOptions, private val policyCache: PolicyCache) : Sessions {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun get(data: GetRequest): StytchResult<GetResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(GetRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/sessions", asMap, headers)
        }

    override fun get(
        data: GetRequest,
        callback: (StytchResult<GetResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(get(data))
        }
    }

    override fun getCompletable(data: GetRequest): CompletableFuture<StytchResult<GetResponse>> =
        coroutineScope.async {
            get(data)
        }.asCompletableFuture()

    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/sessions/authenticate", asJson, headers)
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

    override suspend fun revoke(data: RevokeRequest): StytchResult<RevokeResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(RevokeRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/sessions/revoke", asJson, headers)
        }

    override fun revoke(
        data: RevokeRequest,
        callback: (StytchResult<RevokeResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(revoke(data))
        }
    }

    override fun revokeCompletable(data: RevokeRequest): CompletableFuture<StytchResult<RevokeResponse>> =
        coroutineScope.async {
            revoke(data)
        }.asCompletableFuture()

    override suspend fun exchange(data: ExchangeRequest): StytchResult<ExchangeResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ExchangeRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/sessions/exchange", asJson, headers)
        }

    override fun exchange(
        data: ExchangeRequest,
        callback: (StytchResult<ExchangeResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(exchange(data))
        }
    }

    override fun exchangeCompletable(data: ExchangeRequest): CompletableFuture<StytchResult<ExchangeResponse>> =
        coroutineScope.async {
            exchange(data)
        }.asCompletableFuture()

    override suspend fun getJWKS(data: GetJWKSRequest): StytchResult<GetJWKSResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(GetJWKSRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/sessions/jwks/${data.projectId}", asMap, headers)
        }

    override fun getJWKS(
        data: GetJWKSRequest,
        callback: (StytchResult<GetJWKSResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(getJWKS(data))
        }
    }

    override fun getJWKSCompletable(data: GetJWKSRequest): CompletableFuture<StytchResult<GetJWKSResponse>> =
        coroutineScope.async {
            getJWKS(data)
        }.asCompletableFuture()

    // MANUAL(authenticateJWT_impl)(SERVICE_METHOD)
    override suspend fun authenticateJwt(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck?,
    ): StytchResult<MemberSession?> =
        withContext(Dispatchers.IO) {
            try {
                authenticateJwtLocal(jwt = jwt, maxTokenAgeSeconds = maxTokenAgeSeconds, authorizationCheck = authorizationCheck)
            } catch (e: JWTException) {
                when (val result = authenticate(AuthenticateRequest(sessionJwt = jwt, authorizationCheck = authorizationCheck))) {
                    is StytchResult.Success -> StytchResult.Success(result.value.memberSession)
                    else -> StytchResult.Success(null)
                }
            }
        }

    override fun authenticateJwt(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck?,
        callback: (StytchResult<MemberSession?>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(authenticateJwt(jwt, maxTokenAgeSeconds, authorizationCheck))
        }
    }

    override fun authenticateJwtCompletable(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck?,
    ): CompletableFuture<StytchResult<MemberSession?>> =
        coroutineScope.async {
            authenticateJwt(jwt, maxTokenAgeSeconds, authorizationCheck)
        }.asCompletableFuture()

    override suspend fun authenticateJwtLocal(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck?,
        leeway: Int,
    ): StytchResult<MemberSession?> {
        return try {
            val jwtClaims =
                parseJWTClaims(
                    jwt = jwt,
                    jwtOptions = jwtOptions,
                    jwksClient = jwksClient,
                    options =
                        ParseJWTClaimsOptions(
                            leeway = leeway,
                            maxTokenAgeSeconds = maxTokenAgeSeconds,
                        ),
                )
            val stytchSessionClaims = jwtClaims.payload.claimsMap["https://stytch.com/session"] as? Map<*, *>
            val stytchSessionClaim =
                stytchSessionClaims?.let {
                    val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
                    val adapter: JsonAdapter<Map<*, *>> = moshi.adapter(type)
                    moshi.adapter(StytchB2BSessionClaim::class.java).fromJson(adapter.toJson(it))
                } ?: throw JWTException.JwtMissingClaims

            val orgSessionClaims = jwtClaims.payload.claimsMap["https://stytch.com/organization"] as? Map<*, *>
            val organizationId = orgSessionClaims!!.get("id") as String

            if (authorizationCheck != null) {
                if (stytchSessionClaim.roles == null) {
                    throw JWTException.MissingRolesClaim
                }

                policyCache.performAuthorizationCheck(
                    subjectRoles = stytchSessionClaim.roles,
                    subjectOrgId = organizationId,
                    authorizationCheck = authorizationCheck,
                )
            }

            return StytchResult.Success(
                MemberSession(
                    memberSessionId = stytchSessionClaim.id,
                    memberId = jwtClaims.payload.subject,
                    organizationId = organizationId,
                    authenticationFactors = stytchSessionClaim.authenticationFactors,
                    startedAt = Instant.parse(stytchSessionClaim.startedAt),
                    lastAccessedAt = Instant.parse(stytchSessionClaim.lastAccessedAt),
                    expiresAt = Instant.parse(stytchSessionClaim.expiresAt),
                    customClaims = jwtClaims.customClaims,
                    roles = stytchSessionClaim.roles,
                ),
            )
        } catch (e: JWTException.JwtTooOld) {
            StytchResult.Error(StytchException.Critical(e))
        } catch (e: JWTException.JwtMissingClaims) {
            StytchResult.Error(StytchException.Critical(e))
        } catch (e: Exception) {
            StytchResult.Error(StytchException.Critical(JWTException.JwtError(e)))
        }
    }

    override fun authenticateJwtLocal(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck?,
        leeway: Int,
        callback: (StytchResult<MemberSession?>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(authenticateJwtLocal(jwt, maxTokenAgeSeconds, authorizationCheck, leeway))
        }
    }

    override suspend fun authenticateJwtLocalCompletable(
        jwt: String,
        maxTokenAgeSeconds: Int?,
        authorizationCheck: AuthorizationCheck?,
        leeway: Int,
    ): CompletableFuture<StytchResult<MemberSession?>> =
        coroutineScope.async {
            authenticateJwtLocal(jwt, maxTokenAgeSeconds, authorizationCheck, leeway)
        }.asCompletableFuture()
    // ENDMANUAL(authenticateJWT_impl)
}

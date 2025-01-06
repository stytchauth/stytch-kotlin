package com.stytch.java.consumer.models.oauth

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.consumer.models.sessions.Session
import com.stytch.java.consumer.models.users.User
import java.time.Instant

@JsonClass(generateAdapter = true)
public data class ProviderValues
    @JvmOverloads
    constructor(
        /**
         * The `access_token` that you may use to access the User's data in the provider's API.
         */
        @Json(name = "access_token")
        val accessToken: String,
        /**
         * The `refresh_token` that you may use to obtain a new `access_token` for the User within the provider's API.
         */
        @Json(name = "refresh_token")
        val refreshToken: String,
        /**
         * The `id_token` returned by the OAuth provider. ID Tokens are JWTs that contain structured information about a user. The
         * exact content of each ID Token varies from provider to provider. ID Tokens are returned from OAuth providers that
         * conform to the [OpenID Connect](https://openid.net/foundation/) specification, which is based on OAuth.
         */
        @Json(name = "id_token")
        val idToken: String,
        /**
         * The OAuth scopes included for a given provider. See each provider's section above to see which scopes are included by
         * default and how to add custom scopes.
         */
        @Json(name = "scopes")
        val scopes: List<String>,
        /**
         * The timestamp when the Session expires. Values conform to the RFC 3339 standard and are expressed in UTC, e.g.
         * `2021-12-29T12:33:09Z`.
         */
        @Json(name = "expires_at")
        val expiresAt: Instant? = null,
    )

/**
* Request type for `OAuth.attach`.
*/
@JsonClass(generateAdapter = true)
public data class AttachRequest
    @JvmOverloads
    constructor(
        /**
         * The OAuth provider's name.
         */
        @Json(name = "provider")
        val provider: String,
        /**
         * The unique ID of a specific User.
         */
        @Json(name = "user_id")
        val userId: String? = null,
        /**
         * The `session_token` associated with a User's existing Session.
         */
        @Json(name = "session_token")
        val sessionToken: String? = null,
        /**
         * The `session_jwt` associated with a User's existing Session.
         */
        @Json(name = "session_jwt")
        val sessionJwt: String? = null,
    )

/**
* Response type for `OAuth.attach`.
*/
@JsonClass(generateAdapter = true)
public data class AttachResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * A single-use token for connecting the Stytch User selection from an OAuth Attach request to the corresponding OAuth
         * Start request.
         */
        @Json(name = "oauth_attach_token")
        val oauthAttachToken: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
    )

/**
* Request type for `OAuth.authenticate`.
*/
@JsonClass(generateAdapter = true)
public data class AuthenticateRequest
    @JvmOverloads
    constructor(
        /**
         * The OAuth `token` from the `?token=` query parameter in the URL.
         *
         *       The redirect URL will look like
         * `https://example.com/authenticate?stytch_token_type=oauth&token=rM_kw42CWBhsHLF62V75jELMbvJ87njMe3tFVj7Qupu7`
         *
         *       In the redirect URL, the `stytch_token_type` will be `oauth`. See
         * [here](https://stytch.com/docs/workspace-management/redirect-urls) for more detail.
         */
        @Json(name = "token")
        val token: String,
        /**
         * Reuse an existing session instead of creating a new one. If you provide us with a `session_token`, then we'll update
         * the session represented by this session token with this OAuth factor. If this `session_token` belongs to a different
         * user than the OAuth token, the session_jwt will be ignored. This endpoint will error if both `session_token` and
         * `session_jwt` are provided.
         */
        @Json(name = "session_token")
        val sessionToken: String? = null,
        /**
         * Set the session lifetime to be this many minutes from now. This will start a new session if one doesn't already exist,
         *   returning both an opaque `session_token` and `session_jwt` for this session. Remember that the `session_jwt` will
         * have a fixed lifetime of
         *   five minutes regardless of the underlying session duration, and will need to be refreshed over time.
         *
         *   This value must be a minimum of 5 and a maximum of 527040 minutes (366 days).
         *
         *   If a `session_token` or `session_jwt` is provided then a successful authentication will continue to extend the
         * session this many minutes.
         *
         *   If the `session_duration_minutes` parameter is not specified, a Stytch session will not be created.
         */
        @Json(name = "session_duration_minutes")
        val sessionDurationMinutes: Int? = null,
        /**
         * Reuse an existing session instead of creating a new one. If you provide us with a `session_jwt`, then we'll update the
         * session represented by this JWT with this OAuth factor. If this `session_jwt` belongs to a different user than the
         * OAuth token, the session_jwt will be ignored. This endpoint will error if both `session_token` and `session_jwt` are
         * provided.
         */
        @Json(name = "session_jwt")
        val sessionJwt: String? = null,
        /**
         * Add a custom claims map to the Session being authenticated. Claims are only created if a Session is initialized by
         * providing a value in `session_duration_minutes`. Claims will be included on the Session object and in the JWT. To
         * update a key in an existing Session, supply a new value. To delete a key, supply a null value.
         *
         *   Custom claims made with reserved claims ("iss", "sub", "aud", "exp", "nbf", "iat", "jti") will be ignored. Total
         * custom claims size cannot exceed four kilobytes.
         */
        @Json(name = "session_custom_claims")
        val sessionCustomClaims: Map<String, Any?>? = emptyMap(),
        /**
         * A base64url encoded one time secret used to validate that the request starts and ends on the same device.
         */
        @Json(name = "code_verifier")
        val codeVerifier: String? = null,
    )

/**
* Response type for `OAuth.authenticate`.
*/
@JsonClass(generateAdapter = true)
public data class AuthenticateResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The unique ID of the affected User.
         */
        @Json(name = "user_id")
        val userId: String,
        /**
         * The unique identifier for the User within a given OAuth provider. Also commonly called the "sub" or "Subject field" in
         * OAuth protocols.
         */
        @Json(name = "provider_subject")
        val providerSubject: String,
        /**
         * Denotes the OAuth identity provider that the user has authenticated with, e.g. Google, Facebook, GitHub etc.
         */
        @Json(name = "provider_type")
        val providerType: String,
        /**
         * A secret token for a given Stytch Session.
         */
        @Json(name = "session_token")
        val sessionToken: String,
        /**
         * The JSON Web Token (JWT) for a given Stytch Session.
         */
        @Json(name = "session_jwt")
        val sessionJwt: String,
        /**
         * The `provider_values` object lists relevant identifiers, values, and scopes for a given OAuth provider. For example
         * this object will include a provider's `access_token` that you can use to access the provider's API for a given user.
         *
         *   Note that these values will vary based on the OAuth provider in question, e.g. `id_token` is only returned by OIDC
         * compliant identity providers.
         */
        @Json(name = "provider_values")
        val providerValues: ProviderValues,
        /**
         * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
         * complete response field details.
         */
        @Json(name = "user")
        val user: User,
        /**
         * Indicates if all other of the User's Sessions need to be reset. You should check this field if you aren't using
         * Stytch's Session product. If you are using Stytch's Session product, we revoke the User's other sessions for you.
         */
        @Json(name = "reset_sessions")
        val resetSessions: Boolean,
        /**
         * The unique ID for an OAuth registration.
         */
        @Json(name = "oauth_user_registration_id")
        val oauthUserRegistrationId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * A `Session` object. For backwards compatibility reasons, the session from an OAuth authenticate call is labeled as
         * `user_session`, but is otherwise just a standard stytch `Session` object.
         *
         *   See [GET sessions](https://stytch.com/docs/api/session-get) for complete response fields.
         *
         */
        @Json(name = "user_session")
        val userSession: Session? = null,
    )

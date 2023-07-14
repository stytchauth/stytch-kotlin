package com.stytch.kotlin.consumer.models.magiclinks

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.kotlin.consumer.models.attribute.Attributes
import com.stytch.kotlin.consumer.models.sessions.Session
import com.stytch.kotlin.consumer.models.users.User

@JsonClass(generateAdapter = true)
public data class Options(
    /**
     * Require that the IP address the Magic Link was requested from matches the IP address it's clicked from.
     */
    @Json(name = "ip_match_required")
    val ipMatchRequired: Boolean,
    /**
     * Require that the user agent the Magic Link was requested from matches the user agent it's clicked from.
     */
    @Json(name = "user_agent_match_required")
    val userAgentMatchRequired: Boolean,
)

/**
* Request type for `MagicLinks.authenticate`.
*/
@JsonClass(generateAdapter = true)
public data class AuthenticateRequest(
    /**
     * The token to authenticate.
     */
    @Json(name = "token")
    val token: String,
    /**
     * Provided attributes help with fraud detection.
     */
    @Json(name = "attributes")
    val attributes: Attributes? = null,
    /**
     * Specify optional security settings.
     */
    @Json(name = "options")
    val options: Options? = null,
    /**
     * The `session_token` associated with a User's existing Session.
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
     * The `session_jwt` associated with a User's existing Session.
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
    val sessionCustomClaims: Map<String, Any>? = null,
    /**
     * A base64url encoded one time secret used to validate that the request starts and ends on the same device.
     */
    @Json(name = "code_verifier")
    val codeVerifier: String? = null,
)

/**
* Response type for `MagicLinks.authenticate`.
*/
@JsonClass(generateAdapter = true)
public data class AuthenticateResponse(
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
     * The `email_id` or `phone_id` involved in the given authentication.
     */
    @Json(name = "method_id")
    val methodId: String,
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
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
    /**
     * If you initiate a Session, by including `session_duration_minutes` in your authenticate call, you'll receive a full
     * Session object in the response.
     *
     *   See [GET sessions](https://stytch.com/docs/api/session-get) for complete response fields.
     *
     */
    @Json(name = "session")
    val session: Session? = null,
)

/**
* Request type for `MagicLinks.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateRequest(
    /**
     * The unique ID of a specific User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * Set the expiration for the Magic Link `token` in minutes. By default, it expires in 1 hour. The minimum expiration is 5
     * minutes and the maximum is 7 days (10080 mins).
     */
    @Json(name = "expiration_minutes")
    val expirationMinutes: Int? = null,
    /**
     * Provided attributes help with fraud detection.
     */
    @Json(name = "attributes")
    val attributes: Attributes? = null,
)

/**
* Response type for `MagicLinks.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateResponse(
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
     * The Magic Link `token` that you'll include in your contact method of choice, e.g. email or SMS.
     */
    @Json(name = "token")
    val token: String,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

package com.stytch.kotlin.b2b.models.passwordsexistingpassword

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.kotlin.b2b.models.organizations.Member
import com.stytch.kotlin.b2b.models.organizations.Organization
import com.stytch.kotlin.b2b.models.sessions.MemberSession

@JsonClass(generateAdapter = false)
public enum class ResetRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

/**
* Request type for `ExistingPassword.reset`.
*/
@JsonClass(generateAdapter = true)
public data class ResetRequest(
    /**
     * The email address of the Member.
     */
    @Json(name = "email_address")
    val emailAddress: String,
    /**
     * The member's current password that they supplied.
     */
    @Json(name = "existing_password")
    val existingPassword: String,
    /**
     * The member's elected new password.
     */
    @Json(name = "new_password")
    val newPassword: String,
    /**
     * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
     * on an Organization, so be sure to preserve this value.
     */
    @Json(name = "organization_id")
    val organizationId: String,
    /**
     * A secret token for a given Stytch Session.
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
     *   If the `session_duration_minutes` parameter is not specified, a Stytch session will be created with a 60 minute
     * duration. If you don't want
     *   to use the Stytch session product, you can ignore the session fields in the response.
     */
    @Json(name = "session_duration_minutes")
    val sessionDurationMinutes: Int? = null,
    /**
     * The JSON Web Token (JWT) for a given Stytch Session.
     */
    @Json(name = "session_jwt")
    val sessionJwt: String? = null,
    /**
     * Add a custom claims map to the Session being authenticated. Claims are only created if a Session is initialized by
     * providing a value in
     *   `session_duration_minutes`. Claims will be included on the Session object and in the JWT. To update a key in an
     * existing Session, supply a new value. To
     *   delete a key, supply a null value. Custom claims made with reserved claims (`iss`, `sub`, `aud`, `exp`, `nbf`, `iat`,
     * `jti`) will be ignored.
     *   Total custom claims size cannot exceed four kilobytes.
     */
    @Json(name = "session_custom_claims")
    val sessionCustomClaims: Map<String, Any>? = null,
    @Json(name = "locale")
    val locale: ResetRequestLocale? = null,
)

/**
* Response type for `ExistingPassword.reset`.
*/
@JsonClass(generateAdapter = true)
public data class ResetResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * Globally unique UUID that identifies a specific Member.
     */
    @Json(name = "member_id")
    val memberId: String,
    /**
     * The [Member object](https://stytch.com/docs/b2b/api/member-object).
     */
    @Json(name = "member")
    val member: Member,
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
     * The [Organization object](https://stytch.com/docs/b2b/api/organization-object).
     */
    @Json(name = "organization")
    val organization: Organization,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
    /**
     * The [Session object](https://stytch.com/docs/b2b/api/session-object).
     */
    @Json(name = "member_session")
    val memberSession: MemberSession? = null,
)

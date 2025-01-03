package com.stytch.java.b2b.models.oauth

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.b2b.models.mfa.MfaRequired
import com.stytch.java.b2b.models.organizations.Member
import com.stytch.java.b2b.models.organizations.Organization
import com.stytch.java.b2b.models.sessions.MemberSession
import com.stytch.java.b2b.models.sessions.PrimaryRequired
import java.time.Instant

@JsonClass(generateAdapter = false)
public enum class AuthenticateRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

@JsonClass(generateAdapter = true)
public data class ProviderValues
    @JvmOverloads
    constructor(
        /**
         * The OAuth scopes included for a given provider. See each provider's section above to see which scopes are included by
         * default and how to add custom scopes.
         */
        @Json(name = "scopes")
        val scopes: List<String>,
        /**
         * The `access_token` that you may use to access the User's data in the provider's API.
         */
        @Json(name = "access_token")
        val accessToken: String? = null,
        /**
         * The `refresh_token` that you may use to obtain a new `access_token` for the User within the provider's API.
         */
        @Json(name = "refresh_token")
        val refreshToken: String? = null,
        @Json(name = "expires_at")
        val expiresAt: Instant? = null,
        /**
         * The `id_token` returned by the OAuth provider. ID Tokens are JWTs that contain structured information about a user. The
         * exact content of each ID Token varies from provider to provider. ID Tokens are returned from OAuth providers that
         * conform to the [OpenID Connect](https://openid.net/foundation/) specification, which is based on OAuth.
         */
        @Json(name = "id_token")
        val idToken: String? = null,
    )

/**
* Request type for `OAuth.authenticate`.
*/
@JsonClass(generateAdapter = true)
public data class AuthenticateRequest
    @JvmOverloads
    constructor(
        /**
         * The token to authenticate.
         */
        @Json(name = "oauth_token")
        val oauthToken: String,
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
        val sessionCustomClaims: Map<String, Any?>? = emptyMap(),
        /**
         * A base64url encoded one time secret used to validate that the request starts and ends on the same device.
         */
        @Json(name = "pkce_code_verifier")
        val pkceCodeVerifier: String? = null,
        /**
         * If the needs to complete an MFA step, and the Member has a phone number, this endpoint will pre-emptively send a
         * one-time passcode (OTP) to the Member's phone number. The locale argument will be used to determine which language to
         * use when sending the passcode.
         *
         * Parameter is a [IETF BCP 47 language tag](https://www.w3.org/International/articles/language-tags/), e.g. `"en"`.
         *
         * Currently supported languages are English (`"en"`), Spanish (`"es"`), and Brazilian Portuguese (`"pt-br"`); if no value
         * is provided, the copy defaults to English.
         *
         * Request support for additional languages
         * [here](https://docs.google.com/forms/d/e/1FAIpQLScZSpAu_m2AmLXRT3F3kap-s_mcV6UTBitYn6CdyWP0-o7YjQ/viewform?usp=sf_link")!
         *
         */
        @Json(name = "locale")
        val locale: AuthenticateRequestLocale? = null,
        /**
         * Adds this primary authentication factor to the intermediate session token. If the resulting set of factors satisfies
         * the organization's primary authentication requirements and MFA requirements, the intermediate session token will be
         * consumed and converted to a member session. If not, the same intermediate session token will be returned.
         */
        @Json(name = "intermediate_session_token")
        val intermediateSessionToken: String? = null,
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
         * Globally unique UUID that identifies a specific Member.
         */
        @Json(name = "member_id")
        val memberId: String,
        /**
         * The unique identifier for the User within a given OAuth provider. Also commonly called the `sub` or "Subject field" in
         * OAuth protocols.
         */
        @Json(name = "provider_subject")
        val providerSubject: String,
        /**
         * Denotes the OAuth identity provider that the user has authenticated with, e.g. Google, Microsoft, GitHub etc.
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
         * The [Member object](https://stytch.com/docs/b2b/api/member-object)
         */
        @Json(name = "member")
        val member: Member,
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The [Organization object](https://stytch.com/docs/b2b/api/organization-object).
         */
        @Json(name = "organization")
        val organization: Organization,
        /**
         * This field is deprecated.
         */
        @Json(name = "reset_sessions")
        val resetSessions: Boolean,
        /**
         * Indicates whether the Member is fully authenticated. If false, the Member needs to complete an MFA step to log in to
         * the Organization.
         */
        @Json(name = "member_authenticated")
        val memberAuthenticated: Boolean,
        /**
         * The returned Intermediate Session Token contains an OAuth factor associated with the Member's email address. If this
         * value is non-empty, the member must complete an MFA step to finish logging in to the Organization. The token can be
         * used with the [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms),
         * [TOTP Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-totp), or
         * [Recovery Codes Recover endpoint](https://stytch.com/docs/b2b/api/recovery-codes-recover) to complete an MFA flow and
         * log in to the Organization. It can also be used with the
         * [Exchange Intermediate Session endpoint](https://stytch.com/docs/b2b/api/exchange-intermediate-session) to join a
         * specific Organization that allows the factors represented by the intermediate session token; or the
         * [Create Organization via Discovery endpoint](https://stytch.com/docs/b2b/api/create-organization-via-discovery) to
         * create a new Organization and Member.
         */
        @Json(name = "intermediate_session_token")
        val intermediateSessionToken: String,
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
        /**
         * The `provider_values` object lists relevant identifiers, values, and scopes for a given OAuth provider. For example
         * this object will include a provider's `access_token` that you can use to access the provider's API for a given user.
         *
         *   Note that these values will vary based on the OAuth provider in question, e.g. `id_token` is only returned by
         * Microsoft. Google One Tap does not return access tokens or refresh tokens.
         */
        @Json(name = "provider_values")
        val providerValues: ProviderValues? = null,
        /**
         * Information about the MFA requirements of the Organization and the Member's options for fulfilling MFA.
         */
        @Json(name = "mfa_required")
        val mfaRequired: MfaRequired? = null,
        /**
         * Information about the primary authentication requirements of the Organization.
         */
        @Json(name = "primary_required")
        val primaryRequired: PrimaryRequired? = null,
    )

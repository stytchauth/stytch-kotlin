package com.stytch.java.b2b.models.passwords

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
import com.stytch.java.consumer.models.passwords.Argon2Config
import com.stytch.java.consumer.models.passwords.MD5Config
import com.stytch.java.consumer.models.passwords.PBKDF2Config
import com.stytch.java.consumer.models.passwords.SHA1Config
import com.stytch.java.consumer.models.passwords.ScryptConfig

@JsonClass(generateAdapter = false)
public enum class AuthenticateRequestLocale {
    @Json(name = "en")
    EN,

    @Json(name = "es")
    ES,

    @Json(name = "ptbr")
    PTBR,
}

@JsonClass(generateAdapter = false)
public enum class MigrateRequestHashType {
    @Json(name = "bcrypt")
    BCRYPT,

    @Json(name = "md_5")
    MD_5,

    @Json(name = "argon_2i")
    ARGON_2I,

    @Json(name = "argon_2id")
    ARGON_2ID,

    @Json(name = "sha_1")
    SHA_1,

    @Json(name = "scrypt")
    SCRYPT,

    @Json(name = "phpass")
    PHPASS,

    @Json(name = "pbkdf_2")
    PBKDF_2,
}

@JsonClass(generateAdapter = true)
public data class LudsFeedback
    @JvmOverloads
    constructor(
        /**
         * For LUDS validation, whether the password contains at least one lowercase letter.
         */
        @Json(name = "has_lower_case")
        val hasLowerCase: Boolean,
        /**
         * For LUDS validation, whether the password contains at least one uppercase letter.
         */
        @Json(name = "has_upper_case")
        val hasUpperCase: Boolean,
        /**
         * For LUDS validation, whether the password contains at least one digit.
         */
        @Json(name = "has_digit")
        val hasDigit: Boolean,
        /**
         * For LUDS validation, whether the password contains at least one symbol. Any UTF8 character outside of a-z or A-Z may
         * count as a valid symbol.
         */
        @Json(name = "has_symbol")
        val hasSymbol: Boolean,
        /**
         * For LUDS validation, the number of complexity requirements that are missing from the password.
         *       Check the complexity fields to see which requirements are missing.
         */
        @Json(name = "missing_complexity")
        val missingComplexity: Int,
        /**
         * For LUDS validation, this is the required length of the password that you've set minus the length of the password being
         * checked.
         *       The user will need to add this many characters to the password to make it valid.
         */
        @Json(name = "missing_characters")
        val missingCharacters: Int,
    )

@JsonClass(generateAdapter = true)
public data class ZxcvbnFeedback
    @JvmOverloads
    constructor(
        /**
         * For zxcvbn validation, contains an end user consumable warning if the password is valid but not strong enough.
         */
        @Json(name = "warning")
        val warning: String,
        /**
         * For zxcvbn validation, contains end user consumable suggestions on how to improve the strength of the password.
         */
        @Json(name = "suggestions")
        val suggestions: List<String>,
    )

/**
* Request type for `Passwords.authenticate`.
*/
@JsonClass(generateAdapter = true)
public data class AuthenticateRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The email address of the Member.
         */
        @Json(name = "email_address")
        val emailAddress: String,
        /**
         * The password to authenticate.
         */
        @Json(name = "password")
        val password: String,
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
         * If the Member needs to complete an MFA step, and the Member has a phone number, this endpoint will pre-emptively send a
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
        @Json(name = "intermediate_session_token")
        val intermediateSessionToken: String? = null,
    )

/**
* Response type for `Passwords.authenticate`.
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
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The [Member object](https://stytch.com/docs/b2b/api/member-object)
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
         * The returned Intermediate Session Token contains a password factor associated with the Member.
         *       The token can be used with the
         * [OTP SMS Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-otp-sms),
         * [TOTP Authenticate endpoint](https://stytch.com/docs/b2b/api/authenticate-totp),
         *       or [Recovery Codes Recover endpoint](https://stytch.com/docs/b2b/api/recovery-codes-recover) to complete the MFA
         * flow and log in to the Organization.
         *       Password factors are not transferable between Organizations, so the intermediate session token is not valid for
         * use with discovery endpoints.
         */
        @Json(name = "intermediate_session_token")
        val intermediateSessionToken: String,
        /**
         * Indicates whether the Member is fully authenticated. If false, the Member needs to complete an MFA step to log in to
         * the Organization.
         */
        @Json(name = "member_authenticated")
        val memberAuthenticated: Boolean,
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
         * Information about the MFA requirements of the Organization and the Member's options for fulfilling MFA.
         */
        @Json(name = "mfa_required")
        val mfaRequired: MfaRequired? = null,
    )

/**
* Request type for `Passwords.migrate`.
*/
@JsonClass(generateAdapter = true)
public data class MigrateRequest
    @JvmOverloads
    constructor(
        /**
         * The email address of the Member.
         */
        @Json(name = "email_address")
        val emailAddress: String,
        /**
         * The password hash. For a Scrypt or PBKDF2 hash, the hash needs to be a base64 encoded string.
         */
        @Json(name = "hash")
        val hash: String,
        /**
         * The password hash used. Currently `bcrypt`, `scrypt`, `argon2i`, `argon2id`, `md_5`, `sha_1`, and `pbkdf_2` are
         * supported.
         */
        @Json(name = "hash_type")
        val hashType: MigrateRequestHashType,
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * Optional parameters for MD-5 hash types.
         */
        @Json(name = "md_5_config")
        val md5Config: MD5Config? = null,
        /**
         * Required parameters if the argon2 hex form, as opposed to the encoded form, is supplied.
         */
        @Json(name = "argon_2_config")
        val argon2Config: Argon2Config? = null,
        /**
         * Optional parameters for SHA-1 hash types.
         */
        @Json(name = "sha_1_config")
        val sha1Config: SHA1Config? = null,
        /**
         * Required parameters if the scrypt is not provided in a **PHC encoded form**.
         */
        @Json(name = "scrypt_config")
        val scryptConfig: ScryptConfig? = null,
        /**
         * Required additional parameters for PBKDF2 hash keys. Note that we use the SHA-256 by default, please contact
         * [support@stytch.com](mailto:support@stytch.com) if you use another hashing function.
         */
        @Json(name = "pbkdf_2_config")
        val pbkdf2Config: PBKDF2Config? = null,
        /**
         * The name of the Member. Each field in the name object is optional.
         */
        @Json(name = "name")
        val name: String? = null,
        /**
         * An arbitrary JSON object for storing application-specific data or identity-provider-specific data.
         */
        @Json(name = "trusted_metadata")
        val trustedMetadata: Map<String, Any?>? = emptyMap(),
        /**
         * An arbitrary JSON object of application-specific data. These fields can be edited directly by the
         *   frontend SDK, and should not be used to store critical information. See the
         * [Metadata resource](https://stytch.com/docs/b2b/api/metadata)
         *   for complete field behavior details.
         */
        @Json(name = "untrusted_metadata")
        val untrustedMetadata: Map<String, Any?>? = emptyMap(),
        /**
         * Roles to explicitly assign to this Member.
         *  Will completely replace any existing explicitly assigned roles. See the
         *  [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/role-assignment) for more information about role assignment.
         *
         *    If a Role is removed from a Member, and the Member is also implicitly assigned this Role from an SSO connection
         *    or an SSO group, we will by default revoke any existing sessions for the Member that contain any SSO
         *    authentication factors with the affected connection ID. You can preserve these sessions by passing in the
         *    `preserve_existing_sessions` parameter with a value of `true`.
         */
        @Json(name = "roles")
        val roles: List<String>? = emptyList(),
        /**
         * Whether to preserve existing sessions when explicit Roles that are revoked are also implicitly assigned
         *   by SSO connection or SSO group. Defaults to `false` - that is, existing Member Sessions that contain SSO
         *   authentication factors with the affected SSO connection IDs will be revoked.
         */
        @Json(name = "preserve_existing_sessions")
        val preserveExistingSessions: Boolean? = null,
    )

/**
* Response type for `Passwords.migrate`.
*/
@JsonClass(generateAdapter = true)
public data class MigrateResponse
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
         * A flag indicating `true` if a new Member object was created and `false` if the Member object already existed.
         */
        @Json(name = "member_created")
        val memberCreated: Boolean,
        /**
         * The [Member object](https://stytch.com/docs/b2b/api/member-object)
         */
        @Json(name = "member")
        val member: Member,
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
    )

/**
* Request type for `Passwords.strengthCheck`.
*/
@JsonClass(generateAdapter = true)
public data class StrengthCheckRequest
    @JvmOverloads
    constructor(
        /**
         * The password to authenticate.
         */
        @Json(name = "password")
        val password: String,
        /**
         * The email address of the Member.
         */
        @Json(name = "email_address")
        val emailAddress: String? = null,
    )

/**
* Response type for `Passwords.strengthCheck`.
*/
@JsonClass(generateAdapter = true)
public data class StrengthCheckResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * Returns `true` if the password passes our password validation. We offer two validation options,
         *   [zxcvbn](https://stytch.com/docs/passwords#strength-requirements) is the default option which offers a high level of
         * sophistication.
         *   We also offer [LUDS](https://stytch.com/docs/passwords#strength-requirements). If an email address is included in the
         * call we also
         *   require that the password hasn't been compromised using built-in breach detection powered by
         * [HaveIBeenPwned](https://haveibeenpwned.com/)
         */
        @Json(name = "valid_password")
        val validPassword: Boolean,
        /**
         * The score of the password determined by [zxcvbn](https://github.com/dropbox/zxcvbn). Values will be between 1 and 4, a
         * 3 or greater is required to pass validation.
         */
        @Json(name = "score")
        val score: Int,
        /**
         * Returns `true` if the password has been breached. Powered by [HaveIBeenPwned](https://haveibeenpwned.com/).
         */
        @Json(name = "breached_password")
        val breachedPassword: Boolean,
        /**
         * The strength policy type enforced, either `zxcvbn` or `luds`.
         */
        @Json(name = "strength_policy")
        val strengthPolicy: String,
        /**
         * Will return `true` if breach detection will be evaluated. By default this option is enabled.
         *   This option can be disabled by contacting
         * [support@stytch.com](mailto:support@stytch.com?subject=Password%20strength%20configuration).
         *   If this value is false then `breached_password` will always be `false` as well.
         */
        @Json(name = "breach_detection_on_create")
        val breachDetectionOnCreate: Boolean,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * Feedback for how to improve the password's strength using
         * [luds](https://stytch.com/docs/passwords#strength-requirements).
         */
        @Json(name = "luds_feedback")
        val ludsFeedback: LudsFeedback? = null,
        /**
         * Feedback for how to improve the password's strength using
         * [zxcvbn](https://stytch.com/docs/passwords#strength-requirements).
         */
        @Json(name = "zxcvbn_feedback")
        val zxcvbnFeedback: ZxcvbnFeedback? = null,
    )

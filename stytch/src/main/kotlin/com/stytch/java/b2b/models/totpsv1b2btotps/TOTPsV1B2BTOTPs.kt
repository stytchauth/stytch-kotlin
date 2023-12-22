package com.stytch.java.b2b.models.totpsv1b2btotps

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.b2b.models.organizations.Member
import com.stytch.java.b2b.models.organizations.Organization
import com.stytch.java.b2b.models.sessions.MemberSession

@JsonClass(generateAdapter = true)
public data class AuthenticateRequest
    @JvmOverloads
    constructor(
        @Json(name = "organization_id")
        val organizationId: String,
        @Json(name = "member_id")
        val memberId: String,
        @Json(name = "code")
        val code: String,
        @Json(name = "intermediate_session_token")
        val intermediateSessionToken: String? = null,
        @Json(name = "session_token")
        val sessionToken: String? = null,
        @Json(name = "session_jwt")
        val sessionJwt: String? = null,
        @Json(name = "session_duration_minutes")
        val sessionDurationMinutes: Int? = null,
        @Json(name = "session_custom_claims")
        val sessionCustomClaims: Map<String, Any>? = null,
        @Json(name = "set_mfa_enrollment")
        val setMfaEnrollment: String? = null,
        @Json(name = "set_default_mfa")
        val setDefaultMfa: Boolean? = null,
    )

@JsonClass(generateAdapter = true)
public data class AuthenticateResponse
    @JvmOverloads
    constructor(
        @Json(name = "request_id")
        val requestId: String,
        @Json(name = "member_id")
        val memberId: String,
        @Json(name = "member")
        val member: Member,
        @Json(name = "organization")
        val organization: Organization,
        @Json(name = "session_token")
        val sessionToken: String,
        @Json(name = "session_jwt")
        val sessionJwt: String,
        @Json(name = "status_code")
        val statusCode: Int,
        @Json(name = "member_session")
        val memberSession: MemberSession? = null,
    )

@JsonClass(generateAdapter = true)
public data class MigrateRequest
    @JvmOverloads
    constructor(
        @Json(name = "organization_id")
        val organizationId: String,
        @Json(name = "member_id")
        val memberId: String,
        @Json(name = "secret")
        val secret: String,
        @Json(name = "recovery_codes")
        val recoveryCodes: List<String>,
    )

@JsonClass(generateAdapter = true)
public data class MigrateResponse
    @JvmOverloads
    constructor(
        @Json(name = "request_id")
        val requestId: String,
        @Json(name = "member_id")
        val memberId: String,
        @Json(name = "member")
        val member: Member,
        @Json(name = "organization")
        val organization: Organization,
        @Json(name = "totp_registration_id")
        val totpRegistrationId: String,
        @Json(name = "recovery_codes")
        val recoveryCodes: List<String>,
        @Json(name = "status_code")
        val statusCode: Int,
    )

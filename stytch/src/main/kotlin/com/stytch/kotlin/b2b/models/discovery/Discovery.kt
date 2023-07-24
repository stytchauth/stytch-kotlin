package com.stytch.kotlin.b2b.models.discovery

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.kotlin.b2b.models.mfa.MfaRequired
import com.stytch.kotlin.b2b.models.organizations.Member
import com.stytch.kotlin.b2b.models.organizations.Organization

@JsonClass(generateAdapter = true)
public data class DiscoveredOrganization(
    /**
     * Indicates whether or not the discovery magic link initiated session is valid for the organization's allowed auth method
     * settings.
     *   If not, the member needs to perform additional authentication before logging in - such as password or SSO auth.
     */
    @Json(name = "member_authenticated")
    val memberAuthenticated: Boolean,
    /**
     * The [Organization object](https://stytch.com/docs/b2b/api/organization-object).
     */
    @Json(name = "organization")
    val organization: Organization? = null,
    /**
     * Information about the membership.
     */
    @Json(name = "membership")
    val membership: Membership? = null,
    @Json(name = "primary_required")
    val primaryRequired: PrimaryRequired? = null,
    @Json(name = "mfa_required")
    val mfaRequired: MfaRequired? = null,
)

@JsonClass(generateAdapter = true)
public data class Membership(
    /**
     * Either `active_member`, `pending_member`, `invited_member`, or `eligible_to_join_by_email_domain`
     */
    @Json(name = "type")
    val type: String,
    /**
     * An object containing additional metadata about the membership, if available.
     */
    @Json(name = "details")
    val details: Map<String, Any>? = null,
    /**
     * The [Member object](https://stytch.com/docs/b2b/api/member-object) if one already exists, or null if one does not.
     */
    @Json(name = "member")
    val member: Member? = null,
)

@JsonClass(generateAdapter = true)
public data class PrimaryRequired(
    @Json(name = "allowed_auth_methods")
    val allowedAuthMethods: List<String>,
)

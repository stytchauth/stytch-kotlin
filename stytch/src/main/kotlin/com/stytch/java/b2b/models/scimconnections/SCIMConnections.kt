package com.stytch.java.b2b.models.scimconnections

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.b2b.models.scim.SCIMConnection
import com.stytch.java.b2b.models.scim.SCIMConnectionWithNextToken
import com.stytch.java.b2b.models.scim.SCIMConnectionWithToken
import com.stytch.java.b2b.models.scim.SCIMGroupImplicitRoleAssignments

@JsonClass(generateAdapter = false)
public enum class CreateRequestIdp {
    @Json(name = "unknown")
    UNKNOWN,

    @Json(name = "okta")
    OKTA,

    @Json(name = "microsoftentra")
    MICROSOFTENTRA,

    @Json(name = "cyberark")
    CYBERARK,

    @Json(name = "jumpcloud")
    JUMPCLOUD,

    @Json(name = "onelogin")
    ONELOGIN,

    @Json(name = "pingfederate")
    PINGFEDERATE,

    @Json(name = "rippling")
    RIPPLING,
}

@JsonClass(generateAdapter = false)
public enum class UpdateRequestIdp {
    @Json(name = "unknown")
    UNKNOWN,

    @Json(name = "okta")
    OKTA,

    @Json(name = "microsoftentra")
    MICROSOFTENTRA,
}

/**
* Request type for `Connections.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * A human-readable display name for the connection.
         */
        @Json(name = "display_name")
        val displayName: String? = null,
        @Json(name = "idp")
        val identityProvider: CreateRequestIdp? = null,
    )

/**
* Response type for `Connections.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * The `SCIM Connection` object affected by this API call. See the
         * [SCIM Connection Object](https://stytch.com/docs/b2b/api/scim-connection-object) for complete response field details.
         */
        @Json(name = "connection")
        val connection: SCIMConnectionWithToken? = null,
    )

/**
* Request type for `Connections.delete`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * Globally unique UUID that identifies a specific SSO `connection_id` for a Member.
         */
        @Json(name = "connection_id")
        val connectionId: String,
    )

/**
* Response type for `Connections.delete`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The `connection_id` that was deleted as part of the delete request.
         */
        @Json(name = "connection_id")
        val connectionId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
    )

/**
* Request type for `Connections.get`.
*/
@JsonClass(generateAdapter = true)
public data class GetRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
    )

/**
* Response type for `Connections.get`.
*/
@JsonClass(generateAdapter = true)
public data class GetResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        @Json(name = "connections")
        val connections: List<SCIMConnection>,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
    )

/**
* Request type for `Connections.rotateCancel`.
*/
@JsonClass(generateAdapter = true)
public data class RotateCancelRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The ID of the SCIM connection.
         */
        @Json(name = "connection_id")
        val connectionId: String,
    )

/**
* Response type for `Connections.rotateCancel`.
*/
@JsonClass(generateAdapter = true)
public data class RotateCancelResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * The `SCIM Connection` object affected by this API call. See the
         * [SCIM Connection Object](https://stytch.com/docs/b2b/api/scim-connection-object) for complete response field details.
         */
        @Json(name = "connection")
        val connection: SCIMConnection? = null,
    )

/**
* Request type for `Connections.rotateComplete`.
*/
@JsonClass(generateAdapter = true)
public data class RotateCompleteRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The ID of the SCIM connection.
         */
        @Json(name = "connection_id")
        val connectionId: String,
    )

/**
* Response type for `Connections.rotateComplete`.
*/
@JsonClass(generateAdapter = true)
public data class RotateCompleteResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * The `SCIM Connection` object affected by this API call. See the
         * [SCIM Connection Object](https://stytch.com/docs/b2b/api/scim-connection-object) for complete response field details.
         */
        @Json(name = "connection")
        val connection: SCIMConnection? = null,
    )

/**
* Request type for `Connections.rotateStart`.
*/
@JsonClass(generateAdapter = true)
public data class RotateStartRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The ID of the SCIM connection.
         */
        @Json(name = "connection_id")
        val connectionId: String,
    )

/**
* Response type for `Connections.rotateStart`.
*/
@JsonClass(generateAdapter = true)
public data class RotateStartResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * The `SCIM Connection` object affected by this API call. See the
         * [SCIM Connection Object](https://stytch.com/docs/b2b/api/scim-connection-object) for complete response field details.
         */
        @Json(name = "connection")
        val connection: SCIMConnectionWithNextToken? = null,
    )

/**
* Request type for `Connections.update`.
*/
@JsonClass(generateAdapter = true)
public data class UpdateRequest
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that identifies a specific Organization. The `organization_id` is critical to perform operations
         * on an Organization, so be sure to preserve this value.
         */
        @Json(name = "organization_id")
        val organizationId: String,
        /**
         * The ID of the SCIM connection.
         */
        @Json(name = "connection_id")
        val connectionId: String,
        /**
         * A human-readable display name for the connection.
         */
        @Json(name = "display_name")
        val displayName: String? = null,
        @Json(name = "idp")
        val identityProvider: UpdateRequestIdp? = null,
        @Json(name = "scim_group_implicit_role_assignments")
        val scimGroupImplicitRoleAssignments: List<SCIMGroupImplicitRoleAssignments>? = emptyList(),
    )

/**
* Response type for `Connections.update`.
*/
@JsonClass(generateAdapter = true)
public data class UpdateResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * The `SAML Connection` object affected by this API call. See the
         * [SAML Connection Object](https://stytch.com/docs/b2b/api/saml-connection-object) for complete response field details.
         */
        @Json(name = "connection")
        val connection: SCIMConnection? = null,
    )

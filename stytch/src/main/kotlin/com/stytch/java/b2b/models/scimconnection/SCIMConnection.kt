package com.stytch.java.b2b.models.scimconnection

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
import com.stytch.java.b2b.models.scim.SCIMGroup
import com.stytch.java.b2b.models.scim.SCIMGroupImplicitRoleAssignments
import com.stytch.java.common.methodoptions.Authorization

@JsonClass(generateAdapter = false)
public enum class CreateRequestIdentityProvider {
    @Json(name = "generic")
    GENERIC,

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
public enum class UpdateRequestIdentityProvider {
    @Json(name = "generic")
    GENERIC,

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

public data class CreateRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class DeleteRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class GetGroupsRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class GetRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class RotateCancelRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class RotateCompleteRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class RotateStartRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

public data class UpdateRequestOptions
    @JvmOverloads
    constructor(
        /**
         * Optional authorization object.
         * Pass in an active Stytch Member session token or session JWT and the request
         * will be run using that member's permissions.
         */
        val authorization: Authorization? = null,
    ) {
        internal fun addHeaders(headers: Map<String, String> = emptyMap()): Map<String, String> {
            var res = mapOf<String, String>()
            if (authorization != null) {
                res = authorization.addHeaders(res)
            }
            return res + headers
        }
    }

/**
* Request type for `Connection.create`.
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
        @Json(name = "identity_provider")
        val identityProvider: CreateRequestIdentityProvider? = null,
    )

/**
* Response type for `Connection.create`.
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
* Request type for `Connection.delete`.
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
         * The ID of the SCIM connection.
         */
        @Json(name = "connection_id")
        val connectionId: String,
    )

/**
* Response type for `Connection.delete`.
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
* Request type for `Connection.getGroups`.
*/
@JsonClass(generateAdapter = true)
public data class GetGroupsRequest
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
         * The `cursor` field allows you to paginate through your results. Each result array is limited to 1000 results. If your
         * query returns more than 1000 results, you will need to paginate the responses using the `cursor`. If you receive a
         * response that includes a non-null `next_cursor` in the `results_metadata` object, repeat the search call with the
         * `next_cursor` value set to the `cursor` field to retrieve the next page of results. Continue to make search calls until
         * the `next_cursor` in the response is null.
         */
        @Json(name = "cursor")
        val cursor: String? = null,
        /**
         * The number of search results to return per page. The default limit is 100. A maximum of 1000 results can be returned by
         * a single search request. If the total size of your result set is greater than one page size, you must paginate the
         * response. See the `cursor` field.
         */
        @Json(name = "limit")
        val limit: Long? = null,
    )

/**
* Response type for `Connection.getGroups`.
*/
@JsonClass(generateAdapter = true)
public data class GetGroupsResponse
    @JvmOverloads
    constructor(
        /**
         * A list of SCIM Connection Groups belonging to the connection.
         */
        @Json(name = "scim_groups")
        val scimGroups: List<SCIMGroup>,
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * The `next_cursor` string is returned when your search result contains more than one page of results. This value is
         * passed into your next search call in the `cursor` field.
         */
        @Json(name = "next_cursor")
        val nextCursor: String? = null,
    )

/**
* Request type for `Connection.get`.
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
* Response type for `Connection.get`.
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
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * A [SCIM Connection](https://stytch.com/docs/b2b/api/scim-connection-object) connection belonging to the organization
         * (currently limited to one).
         */
        @Json(name = "connection")
        val connection: SCIMConnection? = null,
    )

/**
* Request type for `Connection.rotateCancel`.
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
* Response type for `Connection.rotateCancel`.
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
* Request type for `Connection.rotateComplete`.
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
* Response type for `Connection.rotateComplete`.
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
* Request type for `Connection.rotateStart`.
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
* Response type for `Connection.rotateStart`.
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
* Request type for `Connection.update`.
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
        @Json(name = "identity_provider")
        val identityProvider: UpdateRequestIdentityProvider? = null,
        /**
         * An array of SCIM group implicit role assignments. Each object in the array must contain a `group_id` and a `role_id`.
         */
        @Json(name = "scim_group_implicit_role_assignments")
        val scimGroupImplicitRoleAssignments: List<SCIMGroupImplicitRoleAssignments>? = emptyList(),
    )

/**
* Response type for `Connection.update`.
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

package com.stytch.java.consumer.models.fraudfingerprint

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.java.consumer.models.fraud.Fingerprints
import com.stytch.java.consumer.models.fraud.Metadata
import com.stytch.java.consumer.models.fraud.Properties
import com.stytch.java.consumer.models.fraud.Verdict
import java.time.Instant

/**
* Request type for `Fingerprint.lookup`.
*/
@JsonClass(generateAdapter = true)
public data class LookupRequest
    @JvmOverloads
    constructor(
        /**
         * The telemetry ID associated with the fingerprint getting looked up.
         */
        @Json(name = "telemetry_id")
        val telemetryId: String,
        /**
         * External identifiers that you wish to associate with the given telemetry ID. You will be able to search for fingerprint
         * results by these identifiers in the DFP analytics dashboard. External metadata fields may not exceed 65 characters.
         * They may only contain alphanumerics and the characters `_` `-` `+` `.` or `@`.
         */
        @Json(name = "external_metadata")
        val externalMetadata: Metadata? = null,
    )

/**
* Response type for `Fingerprint.lookup`.
*/
@JsonClass(generateAdapter = true)
public data class LookupResponse
    @JvmOverloads
    constructor(
        /**
         * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
         * may ask for this value to help identify a specific API call when helping you debug an issue.
         */
        @Json(name = "request_id")
        val requestId: String,
        /**
         * The telemetry ID associated with the fingerprint getting looked up.
         */
        @Json(name = "telemetry_id")
        val telemetryId: String,
        /**
         * A Stytch fingerprint consists of the following identifiers:
         */
        @Json(name = "fingerprints")
        val fingerprints: Fingerprints,
        /**
         * The metadata associated with each fingerprint
         */
        @Json(name = "verdict")
        val verdict: Verdict,
        /**
         * External identifiers that you wish to associate with the given telemetry ID. You will be able to search for fingerprint
         * results by these identifiers in the DFP analytics dashboard. External metadata fields may not exceed 65 characters.
         * They may only contain alphanumerics and the characters `_` `-` `+` `.` or `@`.
         */
        @Json(name = "external_metadata")
        val externalMetadata: Metadata,
        /**
         * The time when the fingerprint was taken. Values conform to the RFC 3339 standard and are expressed in UTC, e.g.
         * `2021-12-29T12:33:09Z`.
         */
        @Json(name = "created_at")
        val createdAt: Instant,
        /**
         * The timestamp when the fingerprint expires. Values conform to the RFC 3339 standard and are expressed in UTC, e.g.
         * `2021-12-29T12:33:09Z`.
         */
        @Json(name = "expires_at")
        val expiresAt: Instant,
        /**
         * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
         * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
         */
        @Json(name = "status_code")
        val statusCode: Int,
        /**
         * Additional information about the user's browser and network.
         */
        @Json(name = "properties")
        val properties: Properties? = null,
    )

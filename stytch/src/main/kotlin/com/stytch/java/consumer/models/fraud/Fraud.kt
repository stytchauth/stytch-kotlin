package com.stytch.java.consumer.models.fraud

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
public enum class RuleAction {
    @Json(name = "ALLOW")
    ALLOW,

    @Json(name = "CHALLENGE")
    CHALLENGE,

    @Json(name = "BLOCK")
    BLOCK,

    @Json(name = "NONE")
    NONE,
}

@JsonClass(generateAdapter = false)
public enum class VerdictAction {
    @Json(name = "ALLOW")
    ALLOW,

    @Json(name = "CHALLENGE")
    CHALLENGE,

    @Json(name = "BLOCK")
    BLOCK,
}

@JsonClass(generateAdapter = true)
public data class ASNProperties
    @JvmOverloads
    constructor(
        /**
         * The Autonomous System Number of the user's network.
         */
        @Json(name = "asn")
        val asn: String,
        /**
         * Public name associated with the ASN.
         */
        @Json(name = "name")
        val name: String,
        /**
         * The CIDR block associated with the ASN.
         */
        @Json(name = "network")
        val network: String,
    )

@JsonClass(generateAdapter = true)
public data class BrowserProperties
    @JvmOverloads
    constructor(
        /**
         * The user agent of the user's browser.
         */
        @Json(name = "user_agent")
        val userAgent: String,
    )

@JsonClass(generateAdapter = true)
public data class Fingerprints
    @JvmOverloads
    constructor(
        /**
         * Combination of signals associated with a specific network commonly known as TLS fingerprinting.
         */
        @Json(name = "network_fingerprint")
        val networkFingerprint: String,
        /**
         * Combinations of signals to identify an operating system and architecture.
         */
        @Json(name = "hardware_fingerprint")
        val hardwareFingerprint: String,
        /**
         * Combination of signals to identify a browser and its specific version.
         */
        @Json(name = "browser_fingerprint")
        val browserFingerprint: String,
        /**
         * Cookie-less way of identifying a unique user.
         */
        @Json(name = "visitor_fingerprint")
        val visitorFingerprint: String,
        /**
         * The cookie stored on the user's device that uniquely identifies them.
         */
        @Json(name = "visitor_id")
        val visitorId: String? = null,
        /**
         * Combination of VisitorID and NetworkFingerprint to create a clear identifier of a browser.
         */
        @Json(name = "browser_id")
        val browserId: String? = null,
    )

@JsonClass(generateAdapter = true)
public data class IPGeoProperties
    @JvmOverloads
    constructor(
        /**
         * The city where the IP is located.
         */
        @Json(name = "city")
        val city: String,
        /**
         * The region where the IP is located.
         */
        @Json(name = "region")
        val region: String,
        /**
         * The country where the IP is located.
         */
        @Json(name = "country")
        val country: String,
    )

@JsonClass(generateAdapter = true)
public data class Metadata
    @JvmOverloads
    constructor(
        /**
         * An external ID, such as a user ID, that you wish to associate with the telemetry ID.
         */
        @Json(name = "external_id")
        val externalId: String? = null,
        /**
         * The organization ID you wish to associate with the telemetry ID.
         */
        @Json(name = "organization_id")
        val organizationId: String? = null,
        /**
         * The user action, such as 'login', that you wish to associate with the telemetry ID.
         */
        @Json(name = "user_action")
        val userAction: String? = null,
    )

@JsonClass(generateAdapter = true)
public data class NetworkProperties
    @JvmOverloads
    constructor(
        /**
         * The IP address of the user.
         */
        @Json(name = "ip_address")
        val ipAddress: String,
        /**
         * Information about the network's ASN (Autonomous System Number).
         */
        @Json(name = "asn")
        val asn: ASNProperties,
        /**
         * Information about the geolocation of the user's IP address.
         */
        @Json(name = "ip_geolocation")
        val ipGeolocation: IPGeoProperties,
        /**
         * Whether the user is using a proxy.
         */
        @Json(name = "is_proxy")
        val isProxy: Boolean,
        /**
         * Whether the user is using a VPN.
         */
        @Json(name = "is_vpn")
        val isVpn: Boolean,
    )

@JsonClass(generateAdapter = true)
public data class Properties
    @JvmOverloads
    constructor(
        @Json(name = "network_properties")
        val networkProperties: NetworkProperties,
        @Json(name = "browser_properties")
        val browserProperties: BrowserProperties,
    )

@JsonClass(generateAdapter = true)
public data class Verdict
    @JvmOverloads
    constructor(
        /**
         * The suggested action based on the fingerprint review. The available actions are:
         *   * `ALLOW` - This is a known valid device grouping or device profile that is part of the default ALLOW listed set of
         * known devices by Stytch. This grouping is made up of verified device profiles that match the characteristics of
         * known/authentic traffic origins
         *   * `BLOCK` - This is a known bad or malicious device profile that is undesirable and should be blocked from completing
         * the privileged action in question
         *   * `CHALLENGE` - This is an unknown or potentially malicious device that should be put through increased friction such
         * as 2FA or other forms of extended user verification before allowing the privileged action to proceed
         *
         */
        @Json(name = "action")
        val action: VerdictAction,
        /**
         * A set of contextual clues to inform why a `CHALLENGE` or `BLOCK` action was suggested. For a list of possible Reasons,
         * please [contact support](mailto:support@stytch.com).
         */
        @Json(name = "reasons")
        val reasons: List<String>,
        /**
         * The operating system and architecture that took the fingerprint.
         */
        @Json(name = "detected_device_type")
        val detectedDeviceType: String,
        /**
         * The assessment of whether this is an authentic device. It will be false if hardware or browser deception is detected.
         */
        @Json(name = "is_authentic_device")
        val isAuthenticDevice: Boolean,
    )

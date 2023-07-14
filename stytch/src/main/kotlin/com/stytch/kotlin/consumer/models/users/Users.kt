package com.stytch.kotlin.consumer.models.users

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stytch.kotlin.consumer.models.attribute.Attributes
import java.time.Instant

public enum class SearchUsersQueryOperator {
    OR,
    AND,
    ;
    public companion object {
        public fun fromString(name: String): SearchUsersQueryOperator? = try {
            valueOf(name.uppercase())
        } catch (e: Exception) {
            null
        }
    }
}

@JsonClass(generateAdapter = true)
public data class BiometricRegistration(
    /**
     * The unique ID for a biometric registration.
     */
    @Json(name = "biometric_registration_id")
    val biometricRegistrationId: String,
    /**
     * The verified boolean denotes whether or not this send method, e.g. phone number, email address, etc., has been
     * successfully authenticated by the User.
     */
    @Json(name = "verified")
    val verified: Boolean,
)

@JsonClass(generateAdapter = true)
public data class CryptoWallet(
    /**
     * The unique ID for a crypto wallet
     */
    @Json(name = "crypto_wallet_id")
    val cryptoWalletId: String,
    /**
     * The actual blockchain address of the User's crypto wallet.
     */
    @Json(name = "crypto_wallet_address")
    val cryptoWalletAddress: String,
    /**
     * The blockchain that the User's crypto wallet operates on, e.g. Ethereum, Solana, etc.
     */
    @Json(name = "crypto_wallet_type")
    val cryptoWalletType: String,
    /**
     * The verified boolean denotes whether or not this send method, e.g. phone number, email address, etc., has been
     * successfully authenticated by the User.
     */
    @Json(name = "verified")
    val verified: Boolean,
)

@JsonClass(generateAdapter = true)
public data class Email(
    /**
     * The unique ID of a specific email address.
     */
    @Json(name = "email_id")
    val emailId: String,
    /**
     * The email address.
     */
    @Json(name = "email")
    val email: String,
    /**
     * The verified boolean denotes whether or not this send method, e.g. phone number, email address, etc., has been
     * successfully authenticated by the User.
     */
    @Json(name = "verified")
    val verified: Boolean,
)

@JsonClass(generateAdapter = true)
public data class Name(
    /**
     * The first name of the user.
     */
    @Json(name = "first_name")
    val firstName: String? = null,
    /**
     * The middle name(s) of the user.
     */
    @Json(name = "middle_name")
    val middleName: String? = null,
    /**
     * The last name of the user.
     */
    @Json(name = "last_name")
    val lastName: String? = null,
)

@JsonClass(generateAdapter = true)
public data class OAuthProvider(
    /**
     * Denotes the OAuth identity provider that the user has authenticated with, e.g. Google, Facebook, GitHub etc.
     */
    @Json(name = "provider_type")
    val providerType: String,
    /**
     * The unique identifier for the User within a given OAuth provider. Also commonly called the "sub" or "Subject field" in
     * OAuth protocols.
     */
    @Json(name = "provider_subject")
    val providerSubject: String,
    /**
     * If available, the `profile_picture_url` is a url of the User's profile picture set in OAuth identity the provider that
     * the User has authenticated with, e.g. Facebook profile picture.
     */
    @Json(name = "profile_picture_url")
    val profilePictureUrl: String,
    /**
     * If available, the `locale` is the User's locale set in the OAuth identity provider that the user has authenticated with.
     */
    @Json(name = "locale")
    val locale: String,
    /**
     * The unique ID for an OAuth registration.
     */
    @Json(name = "oauth_user_registration_id")
    val oauthUserRegistrationId: String,
)

@JsonClass(generateAdapter = true)
public data class Password(
    /**
     * The unique ID of a specific password
     */
    @Json(name = "password_id")
    val passwordId: String,
    /**
     * Indicates whether this password requires a password reset
     */
    @Json(name = "requires_reset")
    val requiresReset: Boolean,
)

@JsonClass(generateAdapter = true)
public data class PhoneNumber(
    /**
     * The unique ID for the phone number.
     */
    @Json(name = "phone_id")
    val phoneId: String,
    /**
     * The phone number.
     */
    @Json(name = "phone_number")
    val phoneNumber: String,
    /**
     * The verified boolean denotes whether or not this send method, e.g. phone number, email address, etc., has been
     * successfully authenticated by the User.
     */
    @Json(name = "verified")
    val verified: Boolean,
)

@JsonClass(generateAdapter = true)
public data class ResultsMetadata(
    /**
     * The total number of results returned by your search query.
     */
    @Json(name = "total")
    val total: Int,
    /**
     * The `next_cursor` string is returned when your search result contains more than one page of results. This value is
     * passed into your next search call in the `cursor` field.
     */
    @Json(name = "next_cursor")
    val nextCursor: String? = null,
)

@JsonClass(generateAdapter = true)
public data class SearchUsersQuery(
    /**
     * The action to perform on the operands. The accepted value are:
     *
     *   `AND` – all the operand values provided must match.
     *
     *   `OR` – the operator will return any matches to at least one of the operand values you supply.
     */
    @Json(name = "operator")
    val operator: SearchUsersQueryOperator,
    /**
     * An array of operand objects that contains all of the filters and values to apply to your search search query.
     */
    @Json(name = "operands")
    val operands: List<Map<String, Any>>,
)

@JsonClass(generateAdapter = true)
public data class TOTP(
    /**
     * The unique ID for a TOTP instance.
     */
    @Json(name = "totp_id")
    val totpId: String,
    /**
     * The verified boolean denotes whether or not this send method, e.g. phone number, email address, etc., has been
     * successfully authenticated by the User.
     */
    @Json(name = "verified")
    val verified: Boolean,
)

@JsonClass(generateAdapter = true)
public data class User(
    /**
     * The unique ID of the affected User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * An array of email objects for the User.
     */
    @Json(name = "emails")
    val emails: List<Email>,
    /**
     * The status of the User. The possible values are `pending` and `active`.
     */
    @Json(name = "status")
    val status: String,
    /**
     * An array of phone number objects linked to the User.
     */
    @Json(name = "phone_numbers")
    val phoneNumbers: List<PhoneNumber>,
    /**
     * An array that contains a list of all WebAuthn registrations for a given User in the Stytch API.
     */
    @Json(name = "webauthn_registrations")
    val webauthnRegistrations: List<WebAuthnRegistration>,
    /**
     * An array of OAuth `provider` objects linked to the User.
     */
    @Json(name = "providers")
    val providers: List<OAuthProvider>,
    /**
     * An array containing a list of all TOTP instances for a given User in the Stytch API.
     */
    @Json(name = "totps")
    val totps: List<TOTP>,
    /**
     * An array contains a list of all crypto wallets for a given User in the Stytch API.
     */
    @Json(name = "crypto_wallets")
    val cryptoWallets: List<CryptoWallet>,
    /**
     * An array that contains a list of all biometric registrations for a given User in the Stytch API.
     */
    @Json(name = "biometric_registrations")
    val biometricRegistrations: List<BiometricRegistration>,
    /**
     * The name of the User. Each field in the `name` object is optional.
     */
    @Json(name = "name")
    val name: Name? = null,
    /**
     * The timestamp of the User's creation. Values conform to the RFC 3339 standard and are expressed in UTC, e.g.
     * `2021-12-29T12:33:09Z`.
     */
    @Json(name = "created_at")
    val createdAt: Instant? = null,
    /**
     * The password object is returned for users with a password.
     */
    @Json(name = "password")
    val password: Password? = null,
    /**
     * The `trusted_metadata` field contains an arbitrary JSON object of application-specific data. See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "trusted_metadata")
    val trustedMetadata: Map<String, Any>? = null,
    /**
     * The `untrusted_metadata` field contains an arbitrary JSON object of application-specific data. Untrusted metadata can
     * be edited by end users directly via the SDK, and **cannot be used to store critical information.** See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "untrusted_metadata")
    val untrustedMetadata: Map<String, Any>? = null,
)

@JsonClass(generateAdapter = true)
public data class WebAuthnRegistration(
    /**
     * The unique ID for the WebAuthn registration.
     */
    @Json(name = "webauthn_registration_id")
    val webauthnRegistrationId: String,
    /**
     * The `domain` on which a WebAuthn registration was started. This will be the domain of your app.
     */
    @Json(name = "domain")
    val domain: String,
    /**
     * The user agent of the User.
     */
    @Json(name = "user_agent")
    val userAgent: String,
    /**
     * The verified boolean denotes whether or not this send method, e.g. phone number, email address, etc., has been
     * successfully authenticated by the User.
     */
    @Json(name = "verified")
    val verified: Boolean,
    /**
     * The `authenticator_type` string displays the requested authenticator type of the WebAuthn device. The two valid types
     * are "platform" and "cross-platform". If no value is present, the WebAuthn device was created without an authenticator
     * type preference.
     */
    @Json(name = "authenticator_type")
    val authenticatorType: String,
)

/**
* Request type for `Users.create`.
*/
@JsonClass(generateAdapter = true)
public data class CreateRequest(
    /**
     * The email address of the end user.
     */
    @Json(name = "email")
    val email: String? = null,
    /**
     * The name of the user. Each field in the name object is optional.
     */
    @Json(name = "name")
    val name: Name? = null,
    /**
     * Provided attributes help with fraud detection.
     */
    @Json(name = "attributes")
    val attributes: Attributes? = null,
    /**
     * The phone number to use for one-time passcodes. The phone number should be in E.164 format. The phone number should be
     * in E.164 format (i.e. +1XXXXXXXXXX). You may use +10000000000 to test this endpoint, see
     * [Testing](https://stytch.com/docs/home#resources_testing) for more detail.
     */
    @Json(name = "phone_number")
    val phoneNumber: String? = null,
    /**
     * Flag for whether or not to save a user as pending vs active in Stytch. Defaults to false.
     *         If true, users will be saved with status pending in Stytch's backend until authenticated.
     *         If false, users will be created as active. An example usage of
     *         a true flag would be to require users to verify their phone by entering the OTP code before creating
     *         an account for them.
     */
    @Json(name = "create_user_as_pending")
    val createUserAsPending: Boolean? = null,
    /**
     * The `trusted_metadata` field contains an arbitrary JSON object of application-specific data. See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "trusted_metadata")
    val trustedMetadata: Map<String, Any>? = null,
    /**
     * The `untrusted_metadata` field contains an arbitrary JSON object of application-specific data. Untrusted metadata can
     * be edited by end users directly via the SDK, and **cannot be used to store critical information.** See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "untrusted_metadata")
    val untrustedMetadata: Map<String, Any>? = null,
)

/**
* Response type for `Users.create`.
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
     * The unique ID of a specific email address.
     */
    @Json(name = "email_id")
    val emailId: String,
    /**
     * The status of the User. The possible values are `pending` and `active`.
     */
    @Json(name = "status")
    val status: String,
    /**
     * The unique ID for the phone number.
     */
    @Json(name = "phone_id")
    val phoneId: String,
    /**
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deleteBiometricRegistration`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteBiometricRegistrationRequest(
    /**
     * The `biometric_registration_id` to be deleted.
     */
    @Json(name = "biometric_registration_id")
    val biometricRegistrationId: String,
)

/**
* Response type for `Users.deleteBiometricRegistration`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteBiometricRegistrationResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deleteCryptoWallet`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteCryptoWalletRequest(
    /**
     * The `crypto_wallet_id` to be deleted.
     */
    @Json(name = "crypto_wallet_id")
    val cryptoWalletId: String,
)

/**
* Response type for `Users.deleteCryptoWallet`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteCryptoWalletResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deleteEmail`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteEmailRequest(
    /**
     * The `email_id` to be deleted.
     */
    @Json(name = "email_id")
    val emailId: String,
)

/**
* Response type for `Users.deleteEmail`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteEmailResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deleteOAuthRegistration`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteOAuthRegistrationRequest(
    /**
     * The `oauth_user_registration_id` to be deleted.
     */
    @Json(name = "oauth_user_registration_id")
    val oauthUserRegistrationId: String,
)

/**
* Response type for `Users.deleteOAuthRegistration`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteOAuthRegistrationResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deletePassword`.
*/
@JsonClass(generateAdapter = true)
public data class DeletePasswordRequest(
    /**
     * The `password_id` to be deleted.
     */
    @Json(name = "password_id")
    val passwordId: String,
)

/**
* Response type for `Users.deletePassword`.
*/
@JsonClass(generateAdapter = true)
public data class DeletePasswordResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deletePhoneNumber`.
*/
@JsonClass(generateAdapter = true)
public data class DeletePhoneNumberRequest(
    /**
     * The `phone_id` to be deleted.
     */
    @Json(name = "phone_id")
    val phoneId: String,
)

/**
* Response type for `Users.deletePhoneNumber`.
*/
@JsonClass(generateAdapter = true)
public data class DeletePhoneNumberResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.delete`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteRequest(
    /**
     * The unique ID of a specific User.
     */
    @Json(name = "user_id")
    val userId: String,
)

/**
* Response type for `Users.delete`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The unique ID of the deleted User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deleteTOTP`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteTOTPRequest(
    /**
     * The `totp_id` to be deleted.
     */
    @Json(name = "totp_id")
    val totpId: String,
)

/**
* Response type for `Users.deleteTOTP`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteTOTPResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.deleteWebAuthnRegistration`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteWebAuthnRegistrationRequest(
    /**
     * The `webauthn_registration_id` to be deleted.
     */
    @Json(name = "webauthn_registration_id")
    val webauthnRegistrationId: String,
)

/**
* Response type for `Users.deleteWebAuthnRegistration`.
*/
@JsonClass(generateAdapter = true)
public data class DeleteWebAuthnRegistrationResponse(
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
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.get`.
*/
@JsonClass(generateAdapter = true)
public data class GetRequest(
    /**
     * The unique ID of a specific User.
     */
    @Json(name = "user_id")
    val userId: String,
)

/**
* Response type for `Users.get`.
*/
@JsonClass(generateAdapter = true)
public data class GetResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The unique ID of the returned User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * An array of email objects for the User.
     */
    @Json(name = "emails")
    val emails: List<Email>,
    /**
     * The status of the User. The possible values are `pending` and `active`.
     */
    @Json(name = "status")
    val status: String,
    /**
     * An array of phone number objects linked to the User.
     */
    @Json(name = "phone_numbers")
    val phoneNumbers: List<PhoneNumber>,
    /**
     * An array that contains a list of all WebAuthn registrations for a given User in the Stytch API.
     */
    @Json(name = "webauthn_registrations")
    val webauthnRegistrations: List<WebAuthnRegistration>,
    /**
     * An array of OAuth `provider` objects linked to the User.
     */
    @Json(name = "providers")
    val providers: List<OAuthProvider>,
    /**
     * An array containing a list of all TOTP instances for a given User in the Stytch API.
     */
    @Json(name = "totps")
    val totps: List<TOTP>,
    /**
     * An array contains a list of all crypto wallets for a given User in the Stytch API.
     */
    @Json(name = "crypto_wallets")
    val cryptoWallets: List<CryptoWallet>,
    /**
     * An array that contains a list of all biometric registrations for a given User in the Stytch API.
     */
    @Json(name = "biometric_registrations")
    val biometricRegistrations: List<BiometricRegistration>,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
    /**
     * The name of the User. Each field in the `name` object is optional.
     */
    @Json(name = "name")
    val name: Name? = null,
    /**
     * The timestamp of the User's creation. Values conform to the RFC 3339 standard and are expressed in UTC, e.g.
     * `2021-12-29T12:33:09Z`.
     */
    @Json(name = "created_at")
    val createdAt: Instant? = null,
    /**
     * The password object is returned for users with a password.
     */
    @Json(name = "password")
    val password: Password? = null,
    /**
     * The `trusted_metadata` field contains an arbitrary JSON object of application-specific data. See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "trusted_metadata")
    val trustedMetadata: Map<String, Any>? = null,
    /**
     * The `untrusted_metadata` field contains an arbitrary JSON object of application-specific data. Untrusted metadata can
     * be edited by end users directly via the SDK, and **cannot be used to store critical information.** See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "untrusted_metadata")
    val untrustedMetadata: Map<String, Any>? = null,
)

/**
* Request type for `Users.search`.
*/
@JsonClass(generateAdapter = true)
public data class SearchRequest(
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
    /**
     * The optional query object contains the operator, i.e. `AND` or `OR`, and the operands that will filter your results.
     * Only an operator is required. If you include no operands, no filtering will be applied. If you include no query object,
     * it will return all results with no filtering applied.
     */
    @Json(name = "query")
    val query: SearchUsersQuery? = null,
)

/**
* Response type for `Users.search`.
*/
@JsonClass(generateAdapter = true)
public data class SearchResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * An array of results that match your search query.
     */
    @Json(name = "results")
    val results: List<User>,
    /**
     * The search `results_metadata` object contains metadata relevant to your specific query like total and `next_cursor`.
     */
    @Json(name = "results_metadata")
    val resultsMetadata: ResultsMetadata,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

/**
* Request type for `Users.update`.
*/
@JsonClass(generateAdapter = true)
public data class UpdateRequest(
    /**
     * The unique ID of a specific User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * The name of the user. Each field in the name object is optional.
     */
    @Json(name = "name")
    val name: Name? = null,
    /**
     * Provided attributes help with fraud detection.
     */
    @Json(name = "attributes")
    val attributes: Attributes? = null,
    /**
     * The `trusted_metadata` field contains an arbitrary JSON object of application-specific data. See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "trusted_metadata")
    val trustedMetadata: Map<String, Any>? = null,
    /**
     * The `untrusted_metadata` field contains an arbitrary JSON object of application-specific data. Untrusted metadata can
     * be edited by end users directly via the SDK, and **cannot be used to store critical information.** See the
     * [Metadata](https://stytch.com/docs/api/metadata) reference for complete field behavior details.
     */
    @Json(name = "untrusted_metadata")
    val untrustedMetadata: Map<String, Any>? = null,
)

/**
* Response type for `Users.update`.
*/
@JsonClass(generateAdapter = true)
public data class UpdateResponse(
    /**
     * Globally unique UUID that is returned with every API call. This value is important to log for debugging purposes; we
     * may ask for this value to help identify a specific API call when helping you debug an issue.
     */
    @Json(name = "request_id")
    val requestId: String,
    /**
     * The unique ID of the updated User.
     */
    @Json(name = "user_id")
    val userId: String,
    /**
     * An array of email objects for the User.
     */
    @Json(name = "emails")
    val emails: List<Email>,
    /**
     * An array of phone number objects linked to the User.
     */
    @Json(name = "phone_numbers")
    val phoneNumbers: List<PhoneNumber>,
    /**
     * An array contains a list of all crypto wallets for a given User in the Stytch API.
     */
    @Json(name = "crypto_wallets")
    val cryptoWallets: List<CryptoWallet>,
    /**
     * The `user` object affected by this API call. See the [Get user endpoint](https://stytch.com/docs/api/get-user) for
     * complete response field details.
     */
    @Json(name = "user")
    val user: User,
    /**
     * The HTTP status code of the response. Stytch follows standard HTTP response status code patterns, e.g. 2XX values
     * equate to success, 3XX values are redirects, 4XX are client errors, and 5XX are server errors.
     */
    @Json(name = "status_code")
    val statusCode: Int,
)

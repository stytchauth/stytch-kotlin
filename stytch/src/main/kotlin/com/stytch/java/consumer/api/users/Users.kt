package com.stytch.java.consumer.api.users

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.StytchResult
import com.stytch.java.consumer.models.users.CreateRequest
import com.stytch.java.consumer.models.users.CreateResponse
import com.stytch.java.consumer.models.users.DeleteBiometricRegistrationRequest
import com.stytch.java.consumer.models.users.DeleteBiometricRegistrationResponse
import com.stytch.java.consumer.models.users.DeleteCryptoWalletRequest
import com.stytch.java.consumer.models.users.DeleteCryptoWalletResponse
import com.stytch.java.consumer.models.users.DeleteEmailRequest
import com.stytch.java.consumer.models.users.DeleteEmailResponse
import com.stytch.java.consumer.models.users.DeleteOAuthRegistrationRequest
import com.stytch.java.consumer.models.users.DeleteOAuthRegistrationResponse
import com.stytch.java.consumer.models.users.DeletePasswordRequest
import com.stytch.java.consumer.models.users.DeletePasswordResponse
import com.stytch.java.consumer.models.users.DeletePhoneNumberRequest
import com.stytch.java.consumer.models.users.DeletePhoneNumberResponse
import com.stytch.java.consumer.models.users.DeleteRequest
import com.stytch.java.consumer.models.users.DeleteResponse
import com.stytch.java.consumer.models.users.DeleteTOTPRequest
import com.stytch.java.consumer.models.users.DeleteTOTPResponse
import com.stytch.java.consumer.models.users.DeleteWebAuthnRegistrationRequest
import com.stytch.java.consumer.models.users.DeleteWebAuthnRegistrationResponse
import com.stytch.java.consumer.models.users.ExchangePrimaryFactorRequest
import com.stytch.java.consumer.models.users.ExchangePrimaryFactorResponse
import com.stytch.java.consumer.models.users.GetRequest
import com.stytch.java.consumer.models.users.GetResponse
import com.stytch.java.consumer.models.users.SearchRequest
import com.stytch.java.consumer.models.users.SearchResponse
import com.stytch.java.consumer.models.users.UpdateRequest
import com.stytch.java.consumer.models.users.UpdateResponse
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture

public interface Users {
    /**
     * Add a User to Stytch. A `user_id` is returned in the response that can then be used to perform other operations within
     * Stytch. An `email` or a `phone_number` is required.
     */
    public suspend fun create(data: CreateRequest): StytchResult<CreateResponse>

    /**
     * Add a User to Stytch. A `user_id` is returned in the response that can then be used to perform other operations within
     * Stytch. An `email` or a `phone_number` is required.
     */
    public fun create(
        data: CreateRequest,
        callback: (StytchResult<CreateResponse>) -> Unit,
    )

    /**
     * Add a User to Stytch. A `user_id` is returned in the response that can then be used to perform other operations within
     * Stytch. An `email` or a `phone_number` is required.
     */
    public fun createCompletable(data: CreateRequest): CompletableFuture<StytchResult<CreateResponse>>

    /**
     * Get information about a specific User.
     */
    public suspend fun get(data: GetRequest): StytchResult<GetResponse>

    /**
     * Get information about a specific User.
     */
    public fun get(
        data: GetRequest,
        callback: (StytchResult<GetResponse>) -> Unit,
    )

    /**
     * Get information about a specific User.
     */
    public fun getCompletable(data: GetRequest): CompletableFuture<StytchResult<GetResponse>>

    /**
     * Search for Users within your Stytch Project.
     *
     * Use the `query` object to filter by different fields. See the `query.operands.filter_value` documentation below for a
     * list of available filters.
     *
     * ### Export all User data
     *
     * Submit an empty `query` in your Search Users request to return all of your Stytch Project's Users.
     *
     * [This Github repository](https://github.com/stytchauth/stytch-node-export-users) contains a utility that leverages the
     * Search Users endpoint to export all of your User data to a CSV or JSON file.
     */
    public suspend fun search(data: SearchRequest): StytchResult<SearchResponse>

    /**
     * Search for Users within your Stytch Project.
     *
     * Use the `query` object to filter by different fields. See the `query.operands.filter_value` documentation below for a
     * list of available filters.
     *
     * ### Export all User data
     *
     * Submit an empty `query` in your Search Users request to return all of your Stytch Project's Users.
     *
     * [This Github repository](https://github.com/stytchauth/stytch-node-export-users) contains a utility that leverages the
     * Search Users endpoint to export all of your User data to a CSV or JSON file.
     */
    public fun search(
        data: SearchRequest,
        callback: (StytchResult<SearchResponse>) -> Unit,
    )

    /**
     * Search for Users within your Stytch Project.
     *
     * Use the `query` object to filter by different fields. See the `query.operands.filter_value` documentation below for a
     * list of available filters.
     *
     * ### Export all User data
     *
     * Submit an empty `query` in your Search Users request to return all of your Stytch Project's Users.
     *
     * [This Github repository](https://github.com/stytchauth/stytch-node-export-users) contains a utility that leverages the
     * Search Users endpoint to export all of your User data to a CSV or JSON file.
     */
    public fun searchCompletable(data: SearchRequest): CompletableFuture<StytchResult<SearchResponse>>

    /**
     * Update a User's attributes.
     *
     * **Note:** In order to add a new email address or phone number to an existing User object, pass the new email address or
     * phone number into the respective `/send` endpoint for the authentication method of your choice. If you specify the
     * existing User's `user_id` while calling the `/send` endpoint, the new, unverified email address or phone number will be
     * added to the existing User object. If the user successfully authenticates within 5 minutes of the `/send` request, the
     * new email address or phone number will be marked as verified and remain permanently on the existing Stytch User.
     * Otherwise, it will be removed from the User object, and any subsequent login requests using that phone number will
     * create a new User. We require this process to guard against an account takeover vulnerability.
     */
    public suspend fun update(data: UpdateRequest): StytchResult<UpdateResponse>

    /**
     * Update a User's attributes.
     *
     * **Note:** In order to add a new email address or phone number to an existing User object, pass the new email address or
     * phone number into the respective `/send` endpoint for the authentication method of your choice. If you specify the
     * existing User's `user_id` while calling the `/send` endpoint, the new, unverified email address or phone number will be
     * added to the existing User object. If the user successfully authenticates within 5 minutes of the `/send` request, the
     * new email address or phone number will be marked as verified and remain permanently on the existing Stytch User.
     * Otherwise, it will be removed from the User object, and any subsequent login requests using that phone number will
     * create a new User. We require this process to guard against an account takeover vulnerability.
     */
    public fun update(
        data: UpdateRequest,
        callback: (StytchResult<UpdateResponse>) -> Unit,
    )

    /**
     * Update a User's attributes.
     *
     * **Note:** In order to add a new email address or phone number to an existing User object, pass the new email address or
     * phone number into the respective `/send` endpoint for the authentication method of your choice. If you specify the
     * existing User's `user_id` while calling the `/send` endpoint, the new, unverified email address or phone number will be
     * added to the existing User object. If the user successfully authenticates within 5 minutes of the `/send` request, the
     * new email address or phone number will be marked as verified and remain permanently on the existing Stytch User.
     * Otherwise, it will be removed from the User object, and any subsequent login requests using that phone number will
     * create a new User. We require this process to guard against an account takeover vulnerability.
     */
    public fun updateCompletable(data: UpdateRequest): CompletableFuture<StytchResult<UpdateResponse>>

    /**
     * Exchange a user's email address or phone number for another.
     *
     * Must pass either an `email_address` or a `phone_number`.
     *
     * This endpoint only works if the user has exactly one factor. You are able to exchange the type of factor for another as
     * well, i.e. exchange an `email_address` for a `phone_number`.
     *
     * Use this endpoint with caution as it performs an admin level action.
     */
    public suspend fun exchangePrimaryFactor(data: ExchangePrimaryFactorRequest): StytchResult<ExchangePrimaryFactorResponse>

    /**
     * Exchange a user's email address or phone number for another.
     *
     * Must pass either an `email_address` or a `phone_number`.
     *
     * This endpoint only works if the user has exactly one factor. You are able to exchange the type of factor for another as
     * well, i.e. exchange an `email_address` for a `phone_number`.
     *
     * Use this endpoint with caution as it performs an admin level action.
     */
    public fun exchangePrimaryFactor(
        data: ExchangePrimaryFactorRequest,
        callback: (StytchResult<ExchangePrimaryFactorResponse>) -> Unit,
    )

    /**
     * Exchange a user's email address or phone number for another.
     *
     * Must pass either an `email_address` or a `phone_number`.
     *
     * This endpoint only works if the user has exactly one factor. You are able to exchange the type of factor for another as
     * well, i.e. exchange an `email_address` for a `phone_number`.
     *
     * Use this endpoint with caution as it performs an admin level action.
     */
    public fun exchangePrimaryFactorCompletable(
        data: ExchangePrimaryFactorRequest,
    ): CompletableFuture<StytchResult<ExchangePrimaryFactorResponse>>

    /**
     * Delete a User from Stytch.
     */
    public suspend fun delete(data: DeleteRequest): StytchResult<DeleteResponse>

    /**
     * Delete a User from Stytch.
     */
    public fun delete(
        data: DeleteRequest,
        callback: (StytchResult<DeleteResponse>) -> Unit,
    )

    /**
     * Delete a User from Stytch.
     */
    public fun deleteCompletable(data: DeleteRequest): CompletableFuture<StytchResult<DeleteResponse>>

    /**
     * Delete an email from a User.
     */
    public suspend fun deleteEmail(data: DeleteEmailRequest): StytchResult<DeleteEmailResponse>

    /**
     * Delete an email from a User.
     */
    public fun deleteEmail(
        data: DeleteEmailRequest,
        callback: (StytchResult<DeleteEmailResponse>) -> Unit,
    )

    /**
     * Delete an email from a User.
     */
    public fun deleteEmailCompletable(data: DeleteEmailRequest): CompletableFuture<StytchResult<DeleteEmailResponse>>

    /**
     * Delete a phone number from a User.
     */
    public suspend fun deletePhoneNumber(data: DeletePhoneNumberRequest): StytchResult<DeletePhoneNumberResponse>

    /**
     * Delete a phone number from a User.
     */
    public fun deletePhoneNumber(
        data: DeletePhoneNumberRequest,
        callback: (StytchResult<DeletePhoneNumberResponse>) -> Unit,
    )

    /**
     * Delete a phone number from a User.
     */
    public fun deletePhoneNumberCompletable(data: DeletePhoneNumberRequest): CompletableFuture<StytchResult<DeletePhoneNumberResponse>>

    /**
     * Delete a WebAuthn registration from a User.
     */
    public suspend fun deleteWebAuthnRegistration(
        data: DeleteWebAuthnRegistrationRequest,
    ): StytchResult<DeleteWebAuthnRegistrationResponse>

    /**
     * Delete a WebAuthn registration from a User.
     */
    public fun deleteWebAuthnRegistration(
        data: DeleteWebAuthnRegistrationRequest,
        callback: (StytchResult<DeleteWebAuthnRegistrationResponse>) -> Unit,
    )

    /**
     * Delete a WebAuthn registration from a User.
     */
    public fun deleteWebAuthnRegistrationCompletable(
        data: DeleteWebAuthnRegistrationRequest,
    ): CompletableFuture<StytchResult<DeleteWebAuthnRegistrationResponse>>

    /**
     * Delete a biometric registration from a User.
     */
    public suspend fun deleteBiometricRegistration(
        data: DeleteBiometricRegistrationRequest,
    ): StytchResult<DeleteBiometricRegistrationResponse>

    /**
     * Delete a biometric registration from a User.
     */
    public fun deleteBiometricRegistration(
        data: DeleteBiometricRegistrationRequest,
        callback: (StytchResult<DeleteBiometricRegistrationResponse>) -> Unit,
    )

    /**
     * Delete a biometric registration from a User.
     */
    public fun deleteBiometricRegistrationCompletable(
        data: DeleteBiometricRegistrationRequest,
    ): CompletableFuture<StytchResult<DeleteBiometricRegistrationResponse>>

    /**
     * Delete a TOTP from a User.
     */
    public suspend fun deleteTOTP(data: DeleteTOTPRequest): StytchResult<DeleteTOTPResponse>

    /**
     * Delete a TOTP from a User.
     */
    public fun deleteTOTP(
        data: DeleteTOTPRequest,
        callback: (StytchResult<DeleteTOTPResponse>) -> Unit,
    )

    /**
     * Delete a TOTP from a User.
     */
    public fun deleteTOTPCompletable(data: DeleteTOTPRequest): CompletableFuture<StytchResult<DeleteTOTPResponse>>

    /**
     * Delete a crypto wallet from a User.
     */
    public suspend fun deleteCryptoWallet(data: DeleteCryptoWalletRequest): StytchResult<DeleteCryptoWalletResponse>

    /**
     * Delete a crypto wallet from a User.
     */
    public fun deleteCryptoWallet(
        data: DeleteCryptoWalletRequest,
        callback: (StytchResult<DeleteCryptoWalletResponse>) -> Unit,
    )

    /**
     * Delete a crypto wallet from a User.
     */
    public fun deleteCryptoWalletCompletable(data: DeleteCryptoWalletRequest): CompletableFuture<StytchResult<DeleteCryptoWalletResponse>>

    /**
     * Delete a password from a User.
     */
    public suspend fun deletePassword(data: DeletePasswordRequest): StytchResult<DeletePasswordResponse>

    /**
     * Delete a password from a User.
     */
    public fun deletePassword(
        data: DeletePasswordRequest,
        callback: (StytchResult<DeletePasswordResponse>) -> Unit,
    )

    /**
     * Delete a password from a User.
     */
    public fun deletePasswordCompletable(data: DeletePasswordRequest): CompletableFuture<StytchResult<DeletePasswordResponse>>

    /**
     * Delete an OAuth registration from a User.
     */
    public suspend fun deleteOAuthRegistration(data: DeleteOAuthRegistrationRequest): StytchResult<DeleteOAuthRegistrationResponse>

    /**
     * Delete an OAuth registration from a User.
     */
    public fun deleteOAuthRegistration(
        data: DeleteOAuthRegistrationRequest,
        callback: (StytchResult<DeleteOAuthRegistrationResponse>) -> Unit,
    )

    /**
     * Delete an OAuth registration from a User.
     */
    public fun deleteOAuthRegistrationCompletable(
        data: DeleteOAuthRegistrationRequest,
    ): CompletableFuture<StytchResult<DeleteOAuthRegistrationResponse>>
}

internal class UsersImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Users {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun create(data: CreateRequest): StytchResult<CreateResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(CreateRequest::class.java).toJson(data)
            httpClient.post("/v1/users", asJson, headers)
        }

    override fun create(
        data: CreateRequest,
        callback: (StytchResult<CreateResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(create(data))
        }
    }

    override fun createCompletable(data: CreateRequest): CompletableFuture<StytchResult<CreateResponse>> =
        coroutineScope.async {
            create(data)
        }.asCompletableFuture()

    override suspend fun get(data: GetRequest): StytchResult<GetResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(GetRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/users/${data.userId}", asMap, headers)
        }

    override fun get(
        data: GetRequest,
        callback: (StytchResult<GetResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(get(data))
        }
    }

    override fun getCompletable(data: GetRequest): CompletableFuture<StytchResult<GetResponse>> =
        coroutineScope.async {
            get(data)
        }.asCompletableFuture()

    override suspend fun search(data: SearchRequest): StytchResult<SearchResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(SearchRequest::class.java).toJson(data)
            httpClient.post("/v1/users/search", asJson, headers)
        }

    override fun search(
        data: SearchRequest,
        callback: (StytchResult<SearchResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(search(data))
        }
    }

    override fun searchCompletable(data: SearchRequest): CompletableFuture<StytchResult<SearchResponse>> =
        coroutineScope.async {
            search(data)
        }.asCompletableFuture()

    override suspend fun update(data: UpdateRequest): StytchResult<UpdateResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(UpdateRequest::class.java).toJson(data)
            httpClient.put("/v1/users/${data.userId}", asJson, headers)
        }

    override fun update(
        data: UpdateRequest,
        callback: (StytchResult<UpdateResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(update(data))
        }
    }

    override fun updateCompletable(data: UpdateRequest): CompletableFuture<StytchResult<UpdateResponse>> =
        coroutineScope.async {
            update(data)
        }.asCompletableFuture()

    override suspend fun exchangePrimaryFactor(data: ExchangePrimaryFactorRequest): StytchResult<ExchangePrimaryFactorResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ExchangePrimaryFactorRequest::class.java).toJson(data)
            httpClient.put("/v1/users/${data.userId}/exchange_primary_factor", asJson, headers)
        }

    override fun exchangePrimaryFactor(
        data: ExchangePrimaryFactorRequest,
        callback: (StytchResult<ExchangePrimaryFactorResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(exchangePrimaryFactor(data))
        }
    }

    override fun exchangePrimaryFactorCompletable(
        data: ExchangePrimaryFactorRequest,
    ): CompletableFuture<StytchResult<ExchangePrimaryFactorResponse>> =
        coroutineScope.async {
            exchangePrimaryFactor(data)
        }.asCompletableFuture()

    override suspend fun delete(data: DeleteRequest): StytchResult<DeleteResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/${data.userId}", headers)
        }

    override fun delete(
        data: DeleteRequest,
        callback: (StytchResult<DeleteResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(delete(data))
        }
    }

    override fun deleteCompletable(data: DeleteRequest): CompletableFuture<StytchResult<DeleteResponse>> =
        coroutineScope.async {
            delete(data)
        }.asCompletableFuture()

    override suspend fun deleteEmail(data: DeleteEmailRequest): StytchResult<DeleteEmailResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/emails/${data.emailId}", headers)
        }

    override fun deleteEmail(
        data: DeleteEmailRequest,
        callback: (StytchResult<DeleteEmailResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deleteEmail(data))
        }
    }

    override fun deleteEmailCompletable(data: DeleteEmailRequest): CompletableFuture<StytchResult<DeleteEmailResponse>> =
        coroutineScope.async {
            deleteEmail(data)
        }.asCompletableFuture()

    override suspend fun deletePhoneNumber(data: DeletePhoneNumberRequest): StytchResult<DeletePhoneNumberResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/phone_numbers/${data.phoneId}", headers)
        }

    override fun deletePhoneNumber(
        data: DeletePhoneNumberRequest,
        callback: (StytchResult<DeletePhoneNumberResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deletePhoneNumber(data))
        }
    }

    override fun deletePhoneNumberCompletable(data: DeletePhoneNumberRequest): CompletableFuture<StytchResult<DeletePhoneNumberResponse>> =
        coroutineScope.async {
            deletePhoneNumber(data)
        }.asCompletableFuture()

    override suspend fun deleteWebAuthnRegistration(
        data: DeleteWebAuthnRegistrationRequest,
    ): StytchResult<DeleteWebAuthnRegistrationResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/webauthn_registrations/${data.webauthnRegistrationId}", headers)
        }

    override fun deleteWebAuthnRegistration(
        data: DeleteWebAuthnRegistrationRequest,
        callback: (StytchResult<DeleteWebAuthnRegistrationResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deleteWebAuthnRegistration(data))
        }
    }

    override fun deleteWebAuthnRegistrationCompletable(
        data: DeleteWebAuthnRegistrationRequest,
    ): CompletableFuture<StytchResult<DeleteWebAuthnRegistrationResponse>> =
        coroutineScope.async {
            deleteWebAuthnRegistration(data)
        }.asCompletableFuture()

    override suspend fun deleteBiometricRegistration(
        data: DeleteBiometricRegistrationRequest,
    ): StytchResult<DeleteBiometricRegistrationResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/biometric_registrations/${data.biometricRegistrationId}", headers)
        }

    override fun deleteBiometricRegistration(
        data: DeleteBiometricRegistrationRequest,
        callback: (StytchResult<DeleteBiometricRegistrationResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deleteBiometricRegistration(data))
        }
    }

    override fun deleteBiometricRegistrationCompletable(
        data: DeleteBiometricRegistrationRequest,
    ): CompletableFuture<StytchResult<DeleteBiometricRegistrationResponse>> =
        coroutineScope.async {
            deleteBiometricRegistration(data)
        }.asCompletableFuture()

    override suspend fun deleteTOTP(data: DeleteTOTPRequest): StytchResult<DeleteTOTPResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/totps/${data.totpId}", headers)
        }

    override fun deleteTOTP(
        data: DeleteTOTPRequest,
        callback: (StytchResult<DeleteTOTPResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deleteTOTP(data))
        }
    }

    override fun deleteTOTPCompletable(data: DeleteTOTPRequest): CompletableFuture<StytchResult<DeleteTOTPResponse>> =
        coroutineScope.async {
            deleteTOTP(data)
        }.asCompletableFuture()

    override suspend fun deleteCryptoWallet(data: DeleteCryptoWalletRequest): StytchResult<DeleteCryptoWalletResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/crypto_wallets/${data.cryptoWalletId}", headers)
        }

    override fun deleteCryptoWallet(
        data: DeleteCryptoWalletRequest,
        callback: (StytchResult<DeleteCryptoWalletResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deleteCryptoWallet(data))
        }
    }

    override fun deleteCryptoWalletCompletable(
        data: DeleteCryptoWalletRequest,
    ): CompletableFuture<StytchResult<DeleteCryptoWalletResponse>> =
        coroutineScope.async {
            deleteCryptoWallet(data)
        }.asCompletableFuture()

    override suspend fun deletePassword(data: DeletePasswordRequest): StytchResult<DeletePasswordResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/passwords/${data.passwordId}", headers)
        }

    override fun deletePassword(
        data: DeletePasswordRequest,
        callback: (StytchResult<DeletePasswordResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deletePassword(data))
        }
    }

    override fun deletePasswordCompletable(data: DeletePasswordRequest): CompletableFuture<StytchResult<DeletePasswordResponse>> =
        coroutineScope.async {
            deletePassword(data)
        }.asCompletableFuture()

    override suspend fun deleteOAuthRegistration(data: DeleteOAuthRegistrationRequest): StytchResult<DeleteOAuthRegistrationResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            httpClient.delete("/v1/users/oauth/${data.oauthUserRegistrationId}", headers)
        }

    override fun deleteOAuthRegistration(
        data: DeleteOAuthRegistrationRequest,
        callback: (StytchResult<DeleteOAuthRegistrationResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(deleteOAuthRegistration(data))
        }
    }

    override fun deleteOAuthRegistrationCompletable(
        data: DeleteOAuthRegistrationRequest,
    ): CompletableFuture<StytchResult<DeleteOAuthRegistrationResponse>> =
        coroutineScope.async {
            deleteOAuthRegistration(data)
        }.asCompletableFuture()
}

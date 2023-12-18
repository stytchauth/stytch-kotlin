package com.stytch.java.b2b.api.organizationsmembers

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.b2b.models.organizations.SearchQuery
import com.stytch.java.b2b.models.organizationsmembers.CreateRequest
import com.stytch.java.b2b.models.organizationsmembers.CreateResponse
import com.stytch.java.b2b.models.organizationsmembers.DangerouslyGetRequest
import com.stytch.java.b2b.models.organizationsmembers.DeleteMFAPhoneNumberRequest
import com.stytch.java.b2b.models.organizationsmembers.DeleteMFAPhoneNumberResponse
import com.stytch.java.b2b.models.organizationsmembers.DeletePasswordRequest
import com.stytch.java.b2b.models.organizationsmembers.DeletePasswordResponse
import com.stytch.java.b2b.models.organizationsmembers.DeleteRequest
import com.stytch.java.b2b.models.organizationsmembers.DeleteResponse
import com.stytch.java.b2b.models.organizationsmembers.GetRequest
import com.stytch.java.b2b.models.organizationsmembers.GetResponse
import com.stytch.java.b2b.models.organizationsmembers.ReactivateRequest
import com.stytch.java.b2b.models.organizationsmembers.ReactivateResponse
import com.stytch.java.b2b.models.organizationsmembers.SearchRequest
import com.stytch.java.b2b.models.organizationsmembers.SearchResponse
import com.stytch.java.b2b.models.organizationsmembers.UpdateRequest
import com.stytch.java.b2b.models.organizationsmembers.UpdateResponse
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.JWTException
import com.stytch.java.common.JwtOptions
import com.stytch.java.common.StytchException
import com.stytch.java.common.StytchResult
import com.stytch.java.common.StytchSessionClaim
import com.stytch.java.consumer.models.sessions.Session
import com.stytch.java.http.HttpClient
import java.time.Instant
import java.util.concurrent.CompletableFuture
import java.util.Date
import kotlinx.coroutines.async
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jose4j.jwk.HttpsJwks
import org.jose4j.jwt.consumer.InvalidJwtException
import org.jose4j.jwt.consumer.JwtConsumerBuilder
import org.jose4j.jwt.MalformedClaimException
import org.jose4j.lang.JoseException
public interface Members {
    /**
    * Updates a Member specified by `organization_id` and `member_id`.
    * 
    * Our RBAC implementation offers out-of-the-box handling of authorization checks for this endpoint. If you pass in
    * a header containing a `session_token` or a `session_jwt` for an unexpired Member Session, we will check that the
    * Member Session has the necessary permissions. The specific permissions needed depend on which of the optional fields
    * are passed in the request. For example, if the `organization_name` argument is provided, the Member Session must have
    * permission to perform the `update.info.name` action on the `stytch.organization` Resource.
    * 
    * If the Member Session does not contain a Role that satisfies the requested permissions, or if the Member's Organization
    * does not match the `organization_id` passed in the request, a 403 error will be thrown. Otherwise, the request will
    * proceed as normal.
    * 
    * To learn more about our RBAC implementation, see our [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/overview).
    */
    public suspend fun update(data: UpdateRequest): StytchResult<UpdateResponse>
    
    /**
    * Updates a Member specified by `organization_id` and `member_id`.
    * 
    * Our RBAC implementation offers out-of-the-box handling of authorization checks for this endpoint. If you pass in
    * a header containing a `session_token` or a `session_jwt` for an unexpired Member Session, we will check that the
    * Member Session has the necessary permissions. The specific permissions needed depend on which of the optional fields
    * are passed in the request. For example, if the `organization_name` argument is provided, the Member Session must have
    * permission to perform the `update.info.name` action on the `stytch.organization` Resource.
    * 
    * If the Member Session does not contain a Role that satisfies the requested permissions, or if the Member's Organization
    * does not match the `organization_id` passed in the request, a 403 error will be thrown. Otherwise, the request will
    * proceed as normal.
    * 
    * To learn more about our RBAC implementation, see our [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/overview).
    */
    public fun update(data: UpdateRequest, callback: (StytchResult<UpdateResponse>) -> Unit)

    /**
    * Updates a Member specified by `organization_id` and `member_id`.
    * 
    * Our RBAC implementation offers out-of-the-box handling of authorization checks for this endpoint. If you pass in
    * a header containing a `session_token` or a `session_jwt` for an unexpired Member Session, we will check that the
    * Member Session has the necessary permissions. The specific permissions needed depend on which of the optional fields
    * are passed in the request. For example, if the `organization_name` argument is provided, the Member Session must have
    * permission to perform the `update.info.name` action on the `stytch.organization` Resource.
    * 
    * If the Member Session does not contain a Role that satisfies the requested permissions, or if the Member's Organization
    * does not match the `organization_id` passed in the request, a 403 error will be thrown. Otherwise, the request will
    * proceed as normal.
    * 
    * To learn more about our RBAC implementation, see our [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/overview).
    */
    public fun updateCompletable(data: UpdateRequest): CompletableFuture<StytchResult<UpdateResponse>>

    /**
    * Deletes a Member specified by `organization_id` and `member_id`. /%}
    */
    public suspend fun delete(data: DeleteRequest): StytchResult<DeleteResponse>
    
    /**
    * Deletes a Member specified by `organization_id` and `member_id`. /%}
    */
    public fun delete(data: DeleteRequest, callback: (StytchResult<DeleteResponse>) -> Unit)

    /**
    * Deletes a Member specified by `organization_id` and `member_id`. /%}
    */
    public fun deleteCompletable(data: DeleteRequest): CompletableFuture<StytchResult<DeleteResponse>>

    /**
    * Reactivates a deleted Member's status and its associated email status (if applicable) to active, specified by
    * `organization_id` and `member_id`. /%}
    */
    public suspend fun reactivate(data: ReactivateRequest): StytchResult<ReactivateResponse>
    
    /**
    * Reactivates a deleted Member's status and its associated email status (if applicable) to active, specified by
    * `organization_id` and `member_id`. /%}
    */
    public fun reactivate(data: ReactivateRequest, callback: (StytchResult<ReactivateResponse>) -> Unit)

    /**
    * Reactivates a deleted Member's status and its associated email status (if applicable) to active, specified by
    * `organization_id` and `member_id`. /%}
    */
    public fun reactivateCompletable(data: ReactivateRequest): CompletableFuture<StytchResult<ReactivateResponse>>

    /**
    * Delete a Member's MFA phone number. 
    * 
    * To change a Member's phone number, you must first call this endpoint to delete the existing phone number.
    * 
    * Existing Member Sessions that include a phone number authentication factor will not be revoked if the phone number is
    * deleted, and MFA will not be enforced until the Member logs in again.
    * If you wish to enforce MFA immediately after a phone number is deleted, you can do so by prompting the Member to enter
    * a new phone number
    * and calling the [OTP SMS send](https://stytch.com/docs/b2b/api/otp-sms-send) endpoint, then calling the
    * [OTP SMS Authenticate](https://stytch.com/docs/b2b/api/authenticate-otp-sms) endpoint.
    *  /%}
    */
    public suspend fun deleteMFAPhoneNumber(data: DeleteMFAPhoneNumberRequest): StytchResult<DeleteMFAPhoneNumberResponse>
    
    /**
    * Delete a Member's MFA phone number. 
    * 
    * To change a Member's phone number, you must first call this endpoint to delete the existing phone number.
    * 
    * Existing Member Sessions that include a phone number authentication factor will not be revoked if the phone number is
    * deleted, and MFA will not be enforced until the Member logs in again.
    * If you wish to enforce MFA immediately after a phone number is deleted, you can do so by prompting the Member to enter
    * a new phone number
    * and calling the [OTP SMS send](https://stytch.com/docs/b2b/api/otp-sms-send) endpoint, then calling the
    * [OTP SMS Authenticate](https://stytch.com/docs/b2b/api/authenticate-otp-sms) endpoint.
    *  /%}
    */
    public fun deleteMFAPhoneNumber(data: DeleteMFAPhoneNumberRequest, callback: (StytchResult<DeleteMFAPhoneNumberResponse>) -> Unit)

    /**
    * Delete a Member's MFA phone number. 
    * 
    * To change a Member's phone number, you must first call this endpoint to delete the existing phone number.
    * 
    * Existing Member Sessions that include a phone number authentication factor will not be revoked if the phone number is
    * deleted, and MFA will not be enforced until the Member logs in again.
    * If you wish to enforce MFA immediately after a phone number is deleted, you can do so by prompting the Member to enter
    * a new phone number
    * and calling the [OTP SMS send](https://stytch.com/docs/b2b/api/otp-sms-send) endpoint, then calling the
    * [OTP SMS Authenticate](https://stytch.com/docs/b2b/api/authenticate-otp-sms) endpoint.
    *  /%}
    */
    public fun deleteMFAPhoneNumberCompletable(data: DeleteMFAPhoneNumberRequest): CompletableFuture<StytchResult<DeleteMFAPhoneNumberResponse>>

    /**
    * Search for Members within specified Organizations. An array with at least one `organization_id` is required. Submitting
    * an empty `query` returns all non-deleted Members within the specified Organizations.
    * 
    * *All fuzzy search filters require a minimum of three characters.
    * 
    * Our RBAC implementation offers out-of-the-box handling of authorization checks for this endpoint. If you pass in
    * a header containing a `session_token` or a `session_jwt` for an unexpired Member Session, we will check that the
    * Member Session has permission to perform the `search` action on the `stytch.member` Resource. In addition, enforcing
    * RBAC on this endpoint means that you may only search for Members within the calling Member's Organization, so the
    * `organization_ids` argument may only contain the `organization_id` of the Member Session passed in the header.
    * 
    * If the Member Session does not contain a Role that satisfies the requested permission, or if the `organization_ids`
    * argument contains an `organization_id` that the Member Session does not belong to, a 403 error will be thrown.
    * Otherwise, the request will proceed as normal.
    * 
    * To learn more about our RBAC implementation, see our [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/overview).
    */
    public suspend fun search(data: SearchRequest): StytchResult<SearchResponse>
    
    /**
    * Search for Members within specified Organizations. An array with at least one `organization_id` is required. Submitting
    * an empty `query` returns all non-deleted Members within the specified Organizations.
    * 
    * *All fuzzy search filters require a minimum of three characters.
    * 
    * Our RBAC implementation offers out-of-the-box handling of authorization checks for this endpoint. If you pass in
    * a header containing a `session_token` or a `session_jwt` for an unexpired Member Session, we will check that the
    * Member Session has permission to perform the `search` action on the `stytch.member` Resource. In addition, enforcing
    * RBAC on this endpoint means that you may only search for Members within the calling Member's Organization, so the
    * `organization_ids` argument may only contain the `organization_id` of the Member Session passed in the header.
    * 
    * If the Member Session does not contain a Role that satisfies the requested permission, or if the `organization_ids`
    * argument contains an `organization_id` that the Member Session does not belong to, a 403 error will be thrown.
    * Otherwise, the request will proceed as normal.
    * 
    * To learn more about our RBAC implementation, see our [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/overview).
    */
    public fun search(data: SearchRequest, callback: (StytchResult<SearchResponse>) -> Unit)

    /**
    * Search for Members within specified Organizations. An array with at least one `organization_id` is required. Submitting
    * an empty `query` returns all non-deleted Members within the specified Organizations.
    * 
    * *All fuzzy search filters require a minimum of three characters.
    * 
    * Our RBAC implementation offers out-of-the-box handling of authorization checks for this endpoint. If you pass in
    * a header containing a `session_token` or a `session_jwt` for an unexpired Member Session, we will check that the
    * Member Session has permission to perform the `search` action on the `stytch.member` Resource. In addition, enforcing
    * RBAC on this endpoint means that you may only search for Members within the calling Member's Organization, so the
    * `organization_ids` argument may only contain the `organization_id` of the Member Session passed in the header.
    * 
    * If the Member Session does not contain a Role that satisfies the requested permission, or if the `organization_ids`
    * argument contains an `organization_id` that the Member Session does not belong to, a 403 error will be thrown.
    * Otherwise, the request will proceed as normal.
    * 
    * To learn more about our RBAC implementation, see our [RBAC guide](https://stytch.com/docs/b2b/guides/rbac/overview).
    */
    public fun searchCompletable(data: SearchRequest): CompletableFuture<StytchResult<SearchResponse>>

    /**
    * Delete a Member's password. /%}
    */
    public suspend fun deletePassword(data: DeletePasswordRequest): StytchResult<DeletePasswordResponse>
    
    /**
    * Delete a Member's password. /%}
    */
    public fun deletePassword(data: DeletePasswordRequest, callback: (StytchResult<DeletePasswordResponse>) -> Unit)

    /**
    * Delete a Member's password. /%}
    */
    public fun deletePasswordCompletable(data: DeletePasswordRequest): CompletableFuture<StytchResult<DeletePasswordResponse>>

    /**
    * Get a Member by `member_id`. This endpoint does not require an `organization_id`, enabling you to get members across
    * organizations. This is a dangerous operation. Incorrect use may open you up to indirect object reference (IDOR)
    * attacks. We recommend using the [Get Member](https://stytch.com/docs/b2b/api/get-member) API instead.
    */
    public suspend fun dangerouslyGet(data: DangerouslyGetRequest): StytchResult<GetResponse>
    
    /**
    * Get a Member by `member_id`. This endpoint does not require an `organization_id`, enabling you to get members across
    * organizations. This is a dangerous operation. Incorrect use may open you up to indirect object reference (IDOR)
    * attacks. We recommend using the [Get Member](https://stytch.com/docs/b2b/api/get-member) API instead.
    */
    public fun dangerouslyGet(data: DangerouslyGetRequest, callback: (StytchResult<GetResponse>) -> Unit)

    /**
    * Get a Member by `member_id`. This endpoint does not require an `organization_id`, enabling you to get members across
    * organizations. This is a dangerous operation. Incorrect use may open you up to indirect object reference (IDOR)
    * attacks. We recommend using the [Get Member](https://stytch.com/docs/b2b/api/get-member) API instead.
    */
    public fun dangerouslyGetCompletable(data: DangerouslyGetRequest): CompletableFuture<StytchResult<GetResponse>>

    /**
    * Creates a Member. An `organization_id` and `email_address` are required. /%}
    */
    public suspend fun create(data: CreateRequest): StytchResult<CreateResponse>
    
    /**
    * Creates a Member. An `organization_id` and `email_address` are required. /%}
    */
    public fun create(data: CreateRequest, callback: (StytchResult<CreateResponse>) -> Unit)

    /**
    * Creates a Member. An `organization_id` and `email_address` are required. /%}
    */
    public fun createCompletable(data: CreateRequest): CompletableFuture<StytchResult<CreateResponse>>

    /**
    * Get a Member by `member_id` or `email_address`.
    */
    public suspend fun get(data: GetRequest): StytchResult<GetResponse>
    
    /**
    * Get a Member by `member_id` or `email_address`.
    */
    public fun get(data: GetRequest, callback: (StytchResult<GetResponse>) -> Unit)

    /**
    * Get a Member by `member_id` or `email_address`.
    */
    public fun getCompletable(data: GetRequest): CompletableFuture<StytchResult<GetResponse>>


}


internal class MembersImpl (private val httpClient: HttpClient, private val coroutineScope: CoroutineScope): Members {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()


    override suspend fun update(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions? = null,
    ): StytchResult<UpdateResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        val asJson = moshi.adapter(UpdateRequest::class.java).toJson(data)
        httpClient.put("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}", asJson, headers)
    }

    override fun update(
        data: UpdateRequest,
        callback: (StytchResult<UpdateResponse>) -> Unit
        methodOptions: UpdateRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(update(data, methodOptions)))
        }
    }

    override fun updateCompletable(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions? = null,
    ): CompletableFuture<StytchResult<UpdateResponse>> =
        coroutineScope.async {
            update(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun delete(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions? = null,
    ): StytchResult<DeleteResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        httpClient.delete("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}", headers)
    }

    override fun delete(
        data: DeleteRequest,
        callback: (StytchResult<DeleteResponse>) -> Unit
        methodOptions: DeleteRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(delete(data, methodOptions)))
        }
    }

    override fun deleteCompletable(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions? = null,
    ): CompletableFuture<StytchResult<DeleteResponse>> =
        coroutineScope.async {
            delete(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun reactivate(
        data: ReactivateRequest,
        methodOptions: ReactivateRequestOptions? = null,
    ): StytchResult<ReactivateResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        val asJson = moshi.adapter(ReactivateRequest::class.java).toJson(data)
        httpClient.put("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}/reactivate", asJson, headers)
    }

    override fun reactivate(
        data: ReactivateRequest,
        callback: (StytchResult<ReactivateResponse>) -> Unit
        methodOptions: ReactivateRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(reactivate(data, methodOptions)))
        }
    }

    override fun reactivateCompletable(
        data: ReactivateRequest,
        methodOptions: ReactivateRequestOptions? = null,
    ): CompletableFuture<StytchResult<ReactivateResponse>> =
        coroutineScope.async {
            reactivate(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun deleteMFAPhoneNumber(
        data: DeleteMFAPhoneNumberRequest,
        methodOptions: DeleteMFAPhoneNumberRequestOptions? = null,
    ): StytchResult<DeleteMFAPhoneNumberResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        httpClient.delete("/v1/b2b/organizations/${data.organizationId}/members/mfa_phone_numbers/${data.memberId}", headers)
    }

    override fun deleteMFAPhoneNumber(
        data: DeleteMFAPhoneNumberRequest,
        callback: (StytchResult<DeleteMFAPhoneNumberResponse>) -> Unit
        methodOptions: DeleteMFAPhoneNumberRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(deleteMFAPhoneNumber(data, methodOptions)))
        }
    }

    override fun deleteMFAPhoneNumberCompletable(
        data: DeleteMFAPhoneNumberRequest,
        methodOptions: DeleteMFAPhoneNumberRequestOptions? = null,
    ): CompletableFuture<StytchResult<DeleteMFAPhoneNumberResponse>> =
        coroutineScope.async {
            deleteMFAPhoneNumber(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun search(
        data: SearchRequest,
        methodOptions: SearchRequestOptions? = null,
    ): StytchResult<SearchResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        val asJson = moshi.adapter(SearchRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/organizations/members/search", asJson, headers)
    }

    override fun search(
        data: SearchRequest,
        callback: (StytchResult<SearchResponse>) -> Unit
        methodOptions: SearchRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(search(data, methodOptions)))
        }
    }

    override fun searchCompletable(
        data: SearchRequest,
        methodOptions: SearchRequestOptions? = null,
    ): CompletableFuture<StytchResult<SearchResponse>> =
        coroutineScope.async {
            search(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun deletePassword(
        data: DeletePasswordRequest,
        methodOptions: DeletePasswordRequestOptions? = null,
    ): StytchResult<DeletePasswordResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        httpClient.delete("/v1/b2b/organizations/${data.organizationId}/members/passwords/${data.memberPasswordId}", headers)
    }

    override fun deletePassword(
        data: DeletePasswordRequest,
        callback: (StytchResult<DeletePasswordResponse>) -> Unit
        methodOptions: DeletePasswordRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(deletePassword(data, methodOptions)))
        }
    }

    override fun deletePasswordCompletable(
        data: DeletePasswordRequest,
        methodOptions: DeletePasswordRequestOptions? = null,
    ): CompletableFuture<StytchResult<DeletePasswordResponse>> =
        coroutineScope.async {
            deletePassword(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun dangerouslyGet(
        data: DangerouslyGetRequest,
    ): StytchResult<GetResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()

        val asJson = moshi.adapter(DangerouslyGetRequest::class.java).toJson(data)
        val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
        val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
        val asMap = adapter.fromJson(asJson) ?: emptyMap()
        httpClient.get("/v1/b2b/organizations/members/dangerously_get/${data.memberId}", asMap, headers)
    }

    override fun dangerouslyGet(
        data: DangerouslyGetRequest,
        callback: (StytchResult<GetResponse>) -> Unit
    ) {
        coroutineScope.launch {
            callback(dangerouslyGet(data))
        }
    }

    override fun dangerouslyGetCompletable(
        data: DangerouslyGetRequest,
    ): CompletableFuture<StytchResult<GetResponse>> =
        coroutineScope.async {
            dangerouslyGet(data)
        }.asCompletableFuture()
    override suspend fun create(
        data: CreateRequest,
        methodOptions: CreateRequestOptions? = null,
    ): StytchResult<CreateResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        val asJson = moshi.adapter(CreateRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/organizations/${data.organizationId}/members", asJson, headers)
    }

    override fun create(
        data: CreateRequest,
        callback: (StytchResult<CreateResponse>) -> Unit
        methodOptions: CreateRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(create(data, methodOptions)))
        }
    }

    override fun createCompletable(
        data: CreateRequest,
        methodOptions: CreateRequestOptions? = null,
    ): CompletableFuture<StytchResult<CreateResponse>> =
        coroutineScope.async {
            create(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun get(
        data: GetRequest,
    ): StytchResult<GetResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()

        val asJson = moshi.adapter(GetRequest::class.java).toJson(data)
        val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
        val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
        val asMap = adapter.fromJson(asJson) ?: emptyMap()
        httpClient.get("/v1/b2b/organizations/${data.organizationId}/member", asMap, headers)
    }

    override fun get(
        data: GetRequest,
        callback: (StytchResult<GetResponse>) -> Unit
    ) {
        coroutineScope.launch {
            callback(get(data))
        }
    }

    override fun getCompletable(
        data: GetRequest,
    ): CompletableFuture<StytchResult<GetResponse>> =
        coroutineScope.async {
            get(data)
        }.asCompletableFuture()

}


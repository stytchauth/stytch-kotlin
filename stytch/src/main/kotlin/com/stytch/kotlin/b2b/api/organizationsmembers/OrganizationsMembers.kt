package com.stytch.kotlin.b2b.api.organizationsmembers

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.kotlin.b2b.models.organizationsmembers.CreateRequest
import com.stytch.kotlin.b2b.models.organizationsmembers.CreateResponse
import com.stytch.kotlin.b2b.models.organizationsmembers.DeletePasswordRequest
import com.stytch.kotlin.b2b.models.organizationsmembers.DeletePasswordResponse
import com.stytch.kotlin.b2b.models.organizationsmembers.DeleteRequest
import com.stytch.kotlin.b2b.models.organizationsmembers.DeleteResponse
import com.stytch.kotlin.b2b.models.organizationsmembers.GetRequest
import com.stytch.kotlin.b2b.models.organizationsmembers.GetResponse
import com.stytch.kotlin.b2b.models.organizationsmembers.SearchRequest
import com.stytch.kotlin.b2b.models.organizationsmembers.SearchResponse
import com.stytch.kotlin.b2b.models.organizationsmembers.UpdateRequest
import com.stytch.kotlin.b2b.models.organizationsmembers.UpdateResponse
import com.stytch.kotlin.common.StytchResult
import com.stytch.kotlin.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
public interface Members {
    /**
     * Updates a Member specified by `organization_id` and `member_id`.
     */
    public suspend fun update(data: UpdateRequest): StytchResult<UpdateResponse>

    /**
     * Updates a Member specified by `organization_id` and `member_id`.
     */
    public fun update(data: UpdateRequest, callback: (StytchResult<UpdateResponse>) -> Unit)

    /**
     * Updates a Member specified by `organization_id` and `member_id`.
     */
    public fun updateCompletable(data: UpdateRequest): CompletableFuture<StytchResult<UpdateResponse>>

    /**
     * Deletes a Member specified by `organization_id` and `member_id`.
     */
    public suspend fun delete(data: DeleteRequest): StytchResult<DeleteResponse>

    /**
     * Deletes a Member specified by `organization_id` and `member_id`.
     */
    public fun delete(data: DeleteRequest, callback: (StytchResult<DeleteResponse>) -> Unit)

    /**
     * Deletes a Member specified by `organization_id` and `member_id`.
     */
    public fun deleteCompletable(data: DeleteRequest): CompletableFuture<StytchResult<DeleteResponse>>

    /**
     * Search for Members within specified Organizations. An array with at least one `organization_id` is required. Submitting
     * an empty `query` returns all Members within the specified Organizations.
     *
     * *All fuzzy search filters require a minimum of three characters.
     */
    public suspend fun search(data: SearchRequest): StytchResult<SearchResponse>

    /**
     * Search for Members within specified Organizations. An array with at least one `organization_id` is required. Submitting
     * an empty `query` returns all Members within the specified Organizations.
     *
     * *All fuzzy search filters require a minimum of three characters.
     */
    public fun search(data: SearchRequest, callback: (StytchResult<SearchResponse>) -> Unit)

    /**
     * Search for Members within specified Organizations. An array with at least one `organization_id` is required. Submitting
     * an empty `query` returns all Members within the specified Organizations.
     *
     * *All fuzzy search filters require a minimum of three characters.
     */
    public fun searchCompletable(data: SearchRequest): CompletableFuture<StytchResult<SearchResponse>>

    /**
     * Delete a Member's password.
     */
    public suspend fun deletePassword(data: DeletePasswordRequest): StytchResult<DeletePasswordResponse>

    /**
     * Delete a Member's password.
     */
    public fun deletePassword(data: DeletePasswordRequest, callback: (StytchResult<DeletePasswordResponse>) -> Unit)

    /**
     * Delete a Member's password.
     */
    public fun deletePasswordCompletable(data: DeletePasswordRequest): CompletableFuture<StytchResult<DeletePasswordResponse>>

    /**
     * Creates a Member. An `organization_id` and `email_address` are required.
     */
    public suspend fun create(data: CreateRequest): StytchResult<CreateResponse>

    /**
     * Creates a Member. An `organization_id` and `email_address` are required.
     */
    public fun create(data: CreateRequest, callback: (StytchResult<CreateResponse>) -> Unit)

    /**
     * Creates a Member. An `organization_id` and `email_address` are required.
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

internal class MembersImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Members {

    private val moshi = Moshi.Builder().build()

    override suspend fun update(data: UpdateRequest): StytchResult<UpdateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(UpdateRequest::class.java).toJson(data)
        httpClient.put("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}", asJson)
    }

    override fun update(data: UpdateRequest, callback: (StytchResult<UpdateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(update(data))
        }
    }

    override fun updateCompletable(data: UpdateRequest): CompletableFuture<StytchResult<UpdateResponse>> =
        coroutineScope.async {
            update(data)
        }.asCompletableFuture()
    override suspend fun delete(data: DeleteRequest): StytchResult<DeleteResponse> = withContext(Dispatchers.IO) {
        httpClient.delete("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}")
    }

    override fun delete(data: DeleteRequest, callback: (StytchResult<DeleteResponse>) -> Unit) {
        coroutineScope.launch {
            callback(delete(data))
        }
    }

    override fun deleteCompletable(data: DeleteRequest): CompletableFuture<StytchResult<DeleteResponse>> =
        coroutineScope.async {
            delete(data)
        }.asCompletableFuture()
    override suspend fun search(data: SearchRequest): StytchResult<SearchResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(SearchRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/organizations/members/search", asJson)
    }

    override fun search(data: SearchRequest, callback: (StytchResult<SearchResponse>) -> Unit) {
        coroutineScope.launch {
            callback(search(data))
        }
    }

    override fun searchCompletable(data: SearchRequest): CompletableFuture<StytchResult<SearchResponse>> =
        coroutineScope.async {
            search(data)
        }.asCompletableFuture()
    override suspend fun deletePassword(data: DeletePasswordRequest): StytchResult<DeletePasswordResponse> = withContext(Dispatchers.IO) {
        httpClient.delete("/v1/b2b/organizations/${data.organizationId}/members/passwords/${data.memberPasswordId}")
    }

    override fun deletePassword(data: DeletePasswordRequest, callback: (StytchResult<DeletePasswordResponse>) -> Unit) {
        coroutineScope.launch {
            callback(deletePassword(data))
        }
    }

    override fun deletePasswordCompletable(data: DeletePasswordRequest): CompletableFuture<StytchResult<DeletePasswordResponse>> =
        coroutineScope.async {
            deletePassword(data)
        }.asCompletableFuture()
    override suspend fun create(data: CreateRequest): StytchResult<CreateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(CreateRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/organizations/${data.organizationId}/members", asJson)
    }

    override fun create(data: CreateRequest, callback: (StytchResult<CreateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(create(data))
        }
    }

    override fun createCompletable(data: CreateRequest): CompletableFuture<StytchResult<CreateResponse>> =
        coroutineScope.async {
            create(data)
        }.asCompletableFuture()
    override suspend fun get(data: GetRequest): StytchResult<GetResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(GetRequest::class.java).toJson(data)
        val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
        val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
        val asMap = adapter.fromJson(asJson) ?: emptyMap()
        httpClient.get("/v1/b2b/organizations/${data.organizationId}/member", asMap)
    }

    override fun get(data: GetRequest, callback: (StytchResult<GetResponse>) -> Unit) {
        coroutineScope.launch {
            callback(get(data))
        }
    }

    override fun getCompletable(data: GetRequest): CompletableFuture<StytchResult<GetResponse>> =
        coroutineScope.async {
            get(data)
        }.asCompletableFuture()
}

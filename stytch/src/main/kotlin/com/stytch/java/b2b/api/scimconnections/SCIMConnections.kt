package com.stytch.java.b2b.api.scimconnections

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.b2b.models.scimconnections.CreateRequest
import com.stytch.java.b2b.models.scimconnections.CreateRequestOptions
import com.stytch.java.b2b.models.scimconnections.CreateResponse
import com.stytch.java.b2b.models.scimconnections.DeleteRequest
import com.stytch.java.b2b.models.scimconnections.DeleteRequestOptions
import com.stytch.java.b2b.models.scimconnections.DeleteResponse
import com.stytch.java.b2b.models.scimconnections.GetRequest
import com.stytch.java.b2b.models.scimconnections.GetRequestOptions
import com.stytch.java.b2b.models.scimconnections.GetResponse
import com.stytch.java.b2b.models.scimconnections.RotateCancelRequest
import com.stytch.java.b2b.models.scimconnections.RotateCancelRequestOptions
import com.stytch.java.b2b.models.scimconnections.RotateCancelResponse
import com.stytch.java.b2b.models.scimconnections.RotateCompleteRequest
import com.stytch.java.b2b.models.scimconnections.RotateCompleteRequestOptions
import com.stytch.java.b2b.models.scimconnections.RotateCompleteResponse
import com.stytch.java.b2b.models.scimconnections.RotateStartRequest
import com.stytch.java.b2b.models.scimconnections.RotateStartRequestOptions
import com.stytch.java.b2b.models.scimconnections.RotateStartResponse
import com.stytch.java.b2b.models.scimconnections.UpdateRequest
import com.stytch.java.b2b.models.scimconnections.UpdateRequestOptions
import com.stytch.java.b2b.models.scimconnections.UpdateResponse
import com.stytch.java.common.InstantAdapter
import com.stytch.java.common.StytchResult
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture

public interface Connections {
    /**
     * Update a SCIM Connection. /%}
     */
    public suspend fun update(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions? = null,
    ): StytchResult<UpdateResponse>

    /**
     * Update a SCIM Connection. /%}
     */
    public fun update(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions? = null,
        callback: (StytchResult<UpdateResponse>) -> Unit,
    )

    /**
     * Update a SCIM Connection. /%}
     */
    public fun updateCompletable(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions? = null,
    ): CompletableFuture<StytchResult<UpdateResponse>>

    /**
     * Deletes a SCIM Connection. /%}
     */
    public suspend fun delete(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions? = null,
    ): StytchResult<DeleteResponse>

    /**
     * Deletes a SCIM Connection. /%}
     */
    public fun delete(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions? = null,
        callback: (StytchResult<DeleteResponse>) -> Unit,
    )

    /**
     * Deletes a SCIM Connection. /%}
     */
    public fun deleteCompletable(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions? = null,
    ): CompletableFuture<StytchResult<DeleteResponse>>

    /**
     * Start a SCIM token rotation. /%}
     */
    public suspend fun rotateStart(
        data: RotateStartRequest,
        methodOptions: RotateStartRequestOptions? = null,
    ): StytchResult<RotateStartResponse>

    /**
     * Start a SCIM token rotation. /%}
     */
    public fun rotateStart(
        data: RotateStartRequest,
        methodOptions: RotateStartRequestOptions? = null,
        callback: (StytchResult<RotateStartResponse>) -> Unit,
    )

    /**
     * Start a SCIM token rotation. /%}
     */
    public fun rotateStartCompletable(
        data: RotateStartRequest,
        methodOptions: RotateStartRequestOptions? = null,
    ): CompletableFuture<StytchResult<RotateStartResponse>>

    /**
     * Completes a SCIM token rotation. This will complete the current token rotation process and update the active token to
     * be the new token supplied in the [start SCIM token rotation](https://stytch.com/docs/b2b/api/scim-rotate-token-start)
     * response. /%}
     */
    public suspend fun rotateComplete(
        data: RotateCompleteRequest,
        methodOptions: RotateCompleteRequestOptions? = null,
    ): StytchResult<RotateCompleteResponse>

    /**
     * Completes a SCIM token rotation. This will complete the current token rotation process and update the active token to
     * be the new token supplied in the [start SCIM token rotation](https://stytch.com/docs/b2b/api/scim-rotate-token-start)
     * response. /%}
     */
    public fun rotateComplete(
        data: RotateCompleteRequest,
        methodOptions: RotateCompleteRequestOptions? = null,
        callback: (StytchResult<RotateCompleteResponse>) -> Unit,
    )

    /**
     * Completes a SCIM token rotation. This will complete the current token rotation process and update the active token to
     * be the new token supplied in the [start SCIM token rotation](https://stytch.com/docs/b2b/api/scim-rotate-token-start)
     * response. /%}
     */
    public fun rotateCompleteCompletable(
        data: RotateCompleteRequest,
        methodOptions: RotateCompleteRequestOptions? = null,
    ): CompletableFuture<StytchResult<RotateCompleteResponse>>

    /**
     * Cancel a SCIM token rotation. This will cancel the current token rotation process, keeping the original token active.
     * /%}
     */
    public suspend fun rotateCancel(
        data: RotateCancelRequest,
        methodOptions: RotateCancelRequestOptions? = null,
    ): StytchResult<RotateCancelResponse>

    /**
     * Cancel a SCIM token rotation. This will cancel the current token rotation process, keeping the original token active.
     * /%}
     */
    public fun rotateCancel(
        data: RotateCancelRequest,
        methodOptions: RotateCancelRequestOptions? = null,
        callback: (StytchResult<RotateCancelResponse>) -> Unit,
    )

    /**
     * Cancel a SCIM token rotation. This will cancel the current token rotation process, keeping the original token active.
     * /%}
     */
    public fun rotateCancelCompletable(
        data: RotateCancelRequest,
        methodOptions: RotateCancelRequestOptions? = null,
    ): CompletableFuture<StytchResult<RotateCancelResponse>>

    /**
     * Create a new SCIM Connection. /%}
     */
    public suspend fun create(
        data: CreateRequest,
        methodOptions: CreateRequestOptions? = null,
    ): StytchResult<CreateResponse>

    /**
     * Create a new SCIM Connection. /%}
     */
    public fun create(
        data: CreateRequest,
        methodOptions: CreateRequestOptions? = null,
        callback: (StytchResult<CreateResponse>) -> Unit,
    )

    /**
     * Create a new SCIM Connection. /%}
     */
    public fun createCompletable(
        data: CreateRequest,
        methodOptions: CreateRequestOptions? = null,
    ): CompletableFuture<StytchResult<CreateResponse>>

    /**
     * Get SCIM Connections. /%}
     */
    public suspend fun get(
        data: GetRequest,
        methodOptions: GetRequestOptions? = null,
    ): StytchResult<GetResponse>

    /**
     * Get SCIM Connections. /%}
     */
    public fun get(
        data: GetRequest,
        methodOptions: GetRequestOptions? = null,
        callback: (StytchResult<GetResponse>) -> Unit,
    )

    /**
     * Get SCIM Connections. /%}
     */
    public fun getCompletable(
        data: GetRequest,
        methodOptions: GetRequestOptions? = null,
    ): CompletableFuture<StytchResult<GetResponse>>
}

internal class ConnectionsImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : Connections {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun update(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions?,
    ): StytchResult<UpdateResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(UpdateRequest::class.java).toJson(data)
            httpClient.put("/v1/b2b/scim/${data.organizationId}/connections/${data.connectionId}", asJson, headers)
        }

    override fun update(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions?,
        callback: (StytchResult<UpdateResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(update(data, methodOptions))
        }
    }

    override fun updateCompletable(
        data: UpdateRequest,
        methodOptions: UpdateRequestOptions?,
    ): CompletableFuture<StytchResult<UpdateResponse>> =
        coroutineScope.async {
            update(data, methodOptions)
        }.asCompletableFuture()

    override suspend fun delete(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions?,
    ): StytchResult<DeleteResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            httpClient.delete("/v1/b2b/scim/${data.organizationId}/connections/${data.connectionId}", headers)
        }

    override fun delete(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions?,
        callback: (StytchResult<DeleteResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(delete(data, methodOptions))
        }
    }

    override fun deleteCompletable(
        data: DeleteRequest,
        methodOptions: DeleteRequestOptions?,
    ): CompletableFuture<StytchResult<DeleteResponse>> =
        coroutineScope.async {
            delete(data, methodOptions)
        }.asCompletableFuture()

    override suspend fun rotateStart(
        data: RotateStartRequest,
        methodOptions: RotateStartRequestOptions?,
    ): StytchResult<RotateStartResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(RotateStartRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/scim/${data.organizationId}/connections/${data.connectionId}/rotate/start", asJson, headers)
        }

    override fun rotateStart(
        data: RotateStartRequest,
        methodOptions: RotateStartRequestOptions?,
        callback: (StytchResult<RotateStartResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(rotateStart(data, methodOptions))
        }
    }

    override fun rotateStartCompletable(
        data: RotateStartRequest,
        methodOptions: RotateStartRequestOptions?,
    ): CompletableFuture<StytchResult<RotateStartResponse>> =
        coroutineScope.async {
            rotateStart(data, methodOptions)
        }.asCompletableFuture()

    override suspend fun rotateComplete(
        data: RotateCompleteRequest,
        methodOptions: RotateCompleteRequestOptions?,
    ): StytchResult<RotateCompleteResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(RotateCompleteRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/scim/${data.organizationId}/connections/${data.connectionId}/rotate/complete", asJson, headers)
        }

    override fun rotateComplete(
        data: RotateCompleteRequest,
        methodOptions: RotateCompleteRequestOptions?,
        callback: (StytchResult<RotateCompleteResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(rotateComplete(data, methodOptions))
        }
    }

    override fun rotateCompleteCompletable(
        data: RotateCompleteRequest,
        methodOptions: RotateCompleteRequestOptions?,
    ): CompletableFuture<StytchResult<RotateCompleteResponse>> =
        coroutineScope.async {
            rotateComplete(data, methodOptions)
        }.asCompletableFuture()

    override suspend fun rotateCancel(
        data: RotateCancelRequest,
        methodOptions: RotateCancelRequestOptions?,
    ): StytchResult<RotateCancelResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(RotateCancelRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/scim/${data.organizationId}/connections/${data.connectionId}/rotate/cancel", asJson, headers)
        }

    override fun rotateCancel(
        data: RotateCancelRequest,
        methodOptions: RotateCancelRequestOptions?,
        callback: (StytchResult<RotateCancelResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(rotateCancel(data, methodOptions))
        }
    }

    override fun rotateCancelCompletable(
        data: RotateCancelRequest,
        methodOptions: RotateCancelRequestOptions?,
    ): CompletableFuture<StytchResult<RotateCancelResponse>> =
        coroutineScope.async {
            rotateCancel(data, methodOptions)
        }.asCompletableFuture()

    override suspend fun create(
        data: CreateRequest,
        methodOptions: CreateRequestOptions?,
    ): StytchResult<CreateResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(CreateRequest::class.java).toJson(data)
            httpClient.post("/v1/b2b/scim/${data.organizationId}/connections", asJson, headers)
        }

    override fun create(
        data: CreateRequest,
        methodOptions: CreateRequestOptions?,
        callback: (StytchResult<CreateResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(create(data, methodOptions))
        }
    }

    override fun createCompletable(
        data: CreateRequest,
        methodOptions: CreateRequestOptions?,
    ): CompletableFuture<StytchResult<CreateResponse>> =
        coroutineScope.async {
            create(data, methodOptions)
        }.asCompletableFuture()

    override suspend fun get(
        data: GetRequest,
        methodOptions: GetRequestOptions?,
    ): StytchResult<GetResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()
            methodOptions?.let {
                headers = methodOptions.addHeaders(headers)
            }

            val asJson = moshi.adapter(GetRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/scim/${data.organizationId}/connections", asMap, headers)
        }

    override fun get(
        data: GetRequest,
        methodOptions: GetRequestOptions?,
        callback: (StytchResult<GetResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(get(data, methodOptions))
        }
    }

    override fun getCompletable(
        data: GetRequest,
        methodOptions: GetRequestOptions?,
    ): CompletableFuture<StytchResult<GetResponse>> =
        coroutineScope.async {
            get(data, methodOptions)
        }.asCompletableFuture()
}

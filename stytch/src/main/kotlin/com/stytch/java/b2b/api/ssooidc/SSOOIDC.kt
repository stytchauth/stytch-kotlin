package com.stytch.java.b2b.api.ssooidc

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.b2b.models.ssooidc.CreateConnectionRequest
import com.stytch.java.b2b.models.ssooidc.CreateConnectionResponse
import com.stytch.java.b2b.models.ssooidc.UpdateConnectionRequest
import com.stytch.java.b2b.models.ssooidc.UpdateConnectionResponse
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
public interface OIDC {
    /**
    * Create a new OIDC Connection. /%}
    */
    public suspend fun createConnection(data: CreateConnectionRequest): StytchResult<CreateConnectionResponse>
    
    /**
    * Create a new OIDC Connection. /%}
    */
    public fun createConnection(data: CreateConnectionRequest, callback: (StytchResult<CreateConnectionResponse>) -> Unit)

    /**
    * Create a new OIDC Connection. /%}
    */
    public fun createConnectionCompletable(data: CreateConnectionRequest): CompletableFuture<StytchResult<CreateConnectionResponse>>

    /**
    * Updates an existing OIDC connection.
    * 
    * When the value of `issuer` changes, Stytch will attempt to retrieve the
    * [OpenID Provider Metadata](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata) document found
    * at `$/.well-known/openid-configuration`.
    * If the metadata document can be retrieved successfully, Stytch will use it to infer the values of `authorization_url`,
    * `token_url`, `jwks_url`, and `userinfo_url`.
    * The `client_id` and `client_secret` values cannot be inferred from the metadata document, and *must* be passed in
    * explicitly.
    * 
    * If the metadata document cannot be retrieved, Stytch will still update the connection using values from the request
    * body.
    * 
    * If the metadata document can be retrieved, and values are passed in the request body, the explicit values passed in
    * from the request body will take precedence over the values inferred from the metadata document. 
    * 
    * Note that a newly created connection will not become active until all of the following fields are provided:
    * * `issuer`
    * * `client_id`
    * * `client_secret`
    * * `authorization_url`
    * * `token_url`
    * * `userinfo_url`
    * * `jwks_url`
    *  /%}
    */
    public suspend fun updateConnection(data: UpdateConnectionRequest): StytchResult<UpdateConnectionResponse>
    
    /**
    * Updates an existing OIDC connection.
    * 
    * When the value of `issuer` changes, Stytch will attempt to retrieve the
    * [OpenID Provider Metadata](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata) document found
    * at `$/.well-known/openid-configuration`.
    * If the metadata document can be retrieved successfully, Stytch will use it to infer the values of `authorization_url`,
    * `token_url`, `jwks_url`, and `userinfo_url`.
    * The `client_id` and `client_secret` values cannot be inferred from the metadata document, and *must* be passed in
    * explicitly.
    * 
    * If the metadata document cannot be retrieved, Stytch will still update the connection using values from the request
    * body.
    * 
    * If the metadata document can be retrieved, and values are passed in the request body, the explicit values passed in
    * from the request body will take precedence over the values inferred from the metadata document. 
    * 
    * Note that a newly created connection will not become active until all of the following fields are provided:
    * * `issuer`
    * * `client_id`
    * * `client_secret`
    * * `authorization_url`
    * * `token_url`
    * * `userinfo_url`
    * * `jwks_url`
    *  /%}
    */
    public fun updateConnection(data: UpdateConnectionRequest, callback: (StytchResult<UpdateConnectionResponse>) -> Unit)

    /**
    * Updates an existing OIDC connection.
    * 
    * When the value of `issuer` changes, Stytch will attempt to retrieve the
    * [OpenID Provider Metadata](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata) document found
    * at `$/.well-known/openid-configuration`.
    * If the metadata document can be retrieved successfully, Stytch will use it to infer the values of `authorization_url`,
    * `token_url`, `jwks_url`, and `userinfo_url`.
    * The `client_id` and `client_secret` values cannot be inferred from the metadata document, and *must* be passed in
    * explicitly.
    * 
    * If the metadata document cannot be retrieved, Stytch will still update the connection using values from the request
    * body.
    * 
    * If the metadata document can be retrieved, and values are passed in the request body, the explicit values passed in
    * from the request body will take precedence over the values inferred from the metadata document. 
    * 
    * Note that a newly created connection will not become active until all of the following fields are provided:
    * * `issuer`
    * * `client_id`
    * * `client_secret`
    * * `authorization_url`
    * * `token_url`
    * * `userinfo_url`
    * * `jwks_url`
    *  /%}
    */
    public fun updateConnectionCompletable(data: UpdateConnectionRequest): CompletableFuture<StytchResult<UpdateConnectionResponse>>


}


internal class OIDCImpl (private val httpClient: HttpClient, private val coroutineScope: CoroutineScope): OIDC {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()


    override suspend fun createConnection(
        data: CreateConnectionRequest,
        methodOptions: CreateConnectionRequestOptions? = null,
    ): StytchResult<CreateConnectionResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        val asJson = moshi.adapter(CreateConnectionRequest::class.java).toJson(data)
        httpClient.post("/v1/b2b/sso/oidc/${data.organizationId}", asJson, headers)
    }

    override fun createConnection(
        data: CreateConnectionRequest,
        callback: (StytchResult<CreateConnectionResponse>) -> Unit
        methodOptions: CreateConnectionRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(createConnection(data, methodOptions)))
        }
    }

    override fun createConnectionCompletable(
        data: CreateConnectionRequest,
        methodOptions: CreateConnectionRequestOptions? = null,
    ): CompletableFuture<StytchResult<CreateConnectionResponse>> =
        coroutineScope.async {
            createConnection(data, methodOptions)
        }.asCompletableFuture()
    override suspend fun updateConnection(
        data: UpdateConnectionRequest,
        methodOptions: UpdateConnectionRequestOptions? = null,
    ): StytchResult<UpdateConnectionResponse> = withContext(Dispatchers.IO) {
        var headers = emptyMap()
        methodOptions?.let {
            headers = methodOptions.addHeaders(headers)
        }

        val asJson = moshi.adapter(UpdateConnectionRequest::class.java).toJson(data)
        httpClient.put("/v1/b2b/sso/oidc/${data.organizationId}/connections/${data.connectionId}", asJson, headers)
    }

    override fun updateConnection(
        data: UpdateConnectionRequest,
        callback: (StytchResult<UpdateConnectionResponse>) -> Unit
        methodOptions: UpdateConnectionRequestOptions? = null,
    ) {
        coroutineScope.launch {
            callback(updateConnection(data, methodOptions)))
        }
    }

    override fun updateConnectionCompletable(
        data: UpdateConnectionRequest,
        methodOptions: UpdateConnectionRequestOptions? = null,
    ): CompletableFuture<StytchResult<UpdateConnectionResponse>> =
        coroutineScope.async {
            updateConnection(data, methodOptions)
        }.asCompletableFuture()

}


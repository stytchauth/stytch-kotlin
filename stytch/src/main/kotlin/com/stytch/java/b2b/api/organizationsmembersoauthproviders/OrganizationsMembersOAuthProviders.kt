package com.stytch.java.b2b.api.organizationsmembersoauthproviders

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.GithubResponse
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.GoogleResponse
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.HubspotResponse
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.MicrosoftResponse
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.ProviderInformationRequest
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.SlackRequest
import com.stytch.java.b2b.models.organizationsmembersoauthproviders.SlackResponse
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

public interface OAuthProviders {
    /**
     * Retrieve the saved Google access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh
     * the
     * access token automatically.
     *
     * Google One Tap does not return access tokens. If the member has only authenticated through Google One Tap and not
     * through a regular Google OAuth flow, this endpoint will not return any tokens.
     *
     * __Note:__ Google does not issue a refresh token on every login, and refresh tokens may expire if unused.
     * To force a refresh token to be issued, pass the `?provider_prompt=consent` query param into the
     * [Start Google OAuth flow](https://stytch.com/docs/b2b/api/oauth-google-start) endpoint.
     */
    public suspend fun google(data: ProviderInformationRequest): StytchResult<GoogleResponse>

    /**
     * Retrieve the saved Google access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh
     * the
     * access token automatically.
     *
     * Google One Tap does not return access tokens. If the member has only authenticated through Google One Tap and not
     * through a regular Google OAuth flow, this endpoint will not return any tokens.
     *
     * __Note:__ Google does not issue a refresh token on every login, and refresh tokens may expire if unused.
     * To force a refresh token to be issued, pass the `?provider_prompt=consent` query param into the
     * [Start Google OAuth flow](https://stytch.com/docs/b2b/api/oauth-google-start) endpoint.
     */
    public fun google(
        data: ProviderInformationRequest,
        callback: (StytchResult<GoogleResponse>) -> Unit,
    )

    /**
     * Retrieve the saved Google access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh
     * the
     * access token automatically.
     *
     * Google One Tap does not return access tokens. If the member has only authenticated through Google One Tap and not
     * through a regular Google OAuth flow, this endpoint will not return any tokens.
     *
     * __Note:__ Google does not issue a refresh token on every login, and refresh tokens may expire if unused.
     * To force a refresh token to be issued, pass the `?provider_prompt=consent` query param into the
     * [Start Google OAuth flow](https://stytch.com/docs/b2b/api/oauth-google-start) endpoint.
     */
    public fun googleCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<GoogleResponse>>

    /**
     * Retrieve the saved Microsoft access token and ID token for a member. After a successful OAuth login, Stytch will save
     * the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh the
     * access token automatically.
     */
    public suspend fun microsoft(data: ProviderInformationRequest): StytchResult<MicrosoftResponse>

    /**
     * Retrieve the saved Microsoft access token and ID token for a member. After a successful OAuth login, Stytch will save
     * the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh the
     * access token automatically.
     */
    public fun microsoft(
        data: ProviderInformationRequest,
        callback: (StytchResult<MicrosoftResponse>) -> Unit,
    )

    /**
     * Retrieve the saved Microsoft access token and ID token for a member. After a successful OAuth login, Stytch will save
     * the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh the
     * access token automatically.
     */
    public fun microsoftCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<MicrosoftResponse>>

    /**
     * Retrieve the saved Slack access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider.
     */
    public suspend fun slack(data: SlackRequest): StytchResult<SlackResponse>

    /**
     * Retrieve the saved Slack access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider.
     */
    public fun slack(
        data: SlackRequest,
        callback: (StytchResult<SlackResponse>) -> Unit,
    )

    /**
     * Retrieve the saved Slack access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider.
     */
    public fun slackCompletable(data: SlackRequest): CompletableFuture<StytchResult<SlackResponse>>

    /**
     * Retrieve the saved Hubspot access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh
     * the
     * access token automatically.
     */
    public suspend fun hubspot(data: ProviderInformationRequest): StytchResult<HubspotResponse>

    /**
     * Retrieve the saved Hubspot access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh
     * the
     * access token automatically.
     */
    public fun hubspot(
        data: ProviderInformationRequest,
        callback: (StytchResult<HubspotResponse>) -> Unit,
    )

    /**
     * Retrieve the saved Hubspot access token and ID token for a member. After a successful OAuth login, Stytch will save the
     * issued access token and ID token from the identity provider. If a refresh token has been issued, Stytch will refresh
     * the
     * access token automatically.
     */
    public fun hubspotCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<HubspotResponse>>

    public suspend fun github(data: ProviderInformationRequest): StytchResult<GithubResponse>

    public fun github(
        data: ProviderInformationRequest,
        callback: (StytchResult<GithubResponse>) -> Unit,
    )

    public fun githubCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<GithubResponse>>
}

internal class OAuthProvidersImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : OAuthProviders {
    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override suspend fun google(data: ProviderInformationRequest): StytchResult<GoogleResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ProviderInformationRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}/oauth_providers/google", asMap, headers)
        }

    override fun google(
        data: ProviderInformationRequest,
        callback: (StytchResult<GoogleResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(google(data))
        }
    }

    override fun googleCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<GoogleResponse>> =
        coroutineScope.async {
            google(data)
        }.asCompletableFuture()

    override suspend fun microsoft(data: ProviderInformationRequest): StytchResult<MicrosoftResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ProviderInformationRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get(
                "/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}/oauth_providers/microsoft",
                asMap,
                headers,
            )
        }

    override fun microsoft(
        data: ProviderInformationRequest,
        callback: (StytchResult<MicrosoftResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(microsoft(data))
        }
    }

    override fun microsoftCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<MicrosoftResponse>> =
        coroutineScope.async {
            microsoft(data)
        }.asCompletableFuture()

    override suspend fun slack(data: SlackRequest): StytchResult<SlackResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(SlackRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}/oauth_providers/slack", asMap, headers)
        }

    override fun slack(
        data: SlackRequest,
        callback: (StytchResult<SlackResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(slack(data))
        }
    }

    override fun slackCompletable(data: SlackRequest): CompletableFuture<StytchResult<SlackResponse>> =
        coroutineScope.async {
            slack(data)
        }.asCompletableFuture()

    override suspend fun hubspot(data: ProviderInformationRequest): StytchResult<HubspotResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ProviderInformationRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}/oauth_providers/hubspot", asMap, headers)
        }

    override fun hubspot(
        data: ProviderInformationRequest,
        callback: (StytchResult<HubspotResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(hubspot(data))
        }
    }

    override fun hubspotCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<HubspotResponse>> =
        coroutineScope.async {
            hubspot(data)
        }.asCompletableFuture()

    override suspend fun github(data: ProviderInformationRequest): StytchResult<GithubResponse> =
        withContext(Dispatchers.IO) {
            var headers = emptyMap<String, String>()

            val asJson = moshi.adapter(ProviderInformationRequest::class.java).toJson(data)
            val type = Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
            val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(type)
            val asMap = adapter.fromJson(asJson) ?: emptyMap()
            httpClient.get("/v1/b2b/organizations/${data.organizationId}/members/${data.memberId}/oauth_providers/github", asMap, headers)
        }

    override fun github(
        data: ProviderInformationRequest,
        callback: (StytchResult<GithubResponse>) -> Unit,
    ) {
        coroutineScope.launch {
            callback(github(data))
        }
    }

    override fun githubCompletable(data: ProviderInformationRequest): CompletableFuture<StytchResult<GithubResponse>> =
        coroutineScope.async {
            github(data)
        }.asCompletableFuture()
}

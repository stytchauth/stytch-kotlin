package com.stytch.kotlin.consumer.api.webauthn

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.kotlin.common.StytchResult
import com.stytch.kotlin.consumer.models.webauthn.AuthenticateRequest
import com.stytch.kotlin.consumer.models.webauthn.AuthenticateResponse
import com.stytch.kotlin.consumer.models.webauthn.AuthenticateStartRequest
import com.stytch.kotlin.consumer.models.webauthn.AuthenticateStartResponse
import com.stytch.kotlin.consumer.models.webauthn.RegisterRequest
import com.stytch.kotlin.consumer.models.webauthn.RegisterResponse
import com.stytch.kotlin.consumer.models.webauthn.RegisterStartRequest
import com.stytch.kotlin.consumer.models.webauthn.RegisterStartResponse
import com.stytch.kotlin.http.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

public interface WebAuthn {
    /**
     * Initiate the process of creating a new WebAuthn registration. After calling this endpoint, the browser will need to
     * call [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) with the data from
     * [public_key_credential_creation_options](https://w3c.github.io/webauthn/#dictionary-makecredentialoptions) passed to
     * the [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) request via the public
     * key argument. We recommend using the `create()` wrapper provided by the webauthn-json library.
     *
     * If you are not using the [webauthn-json](https://github.com/github/webauthn-json) library, the
     * `public_key_credential_creation_options` will need to be converted to a suitable public key by unmarshalling the JSON,
     * base64 decoding the user ID field, and converting user ID and the challenge fields into an array buffer.
     */
    public suspend fun registerStart(data: RegisterStartRequest): StytchResult<RegisterStartResponse>

    /**
     * Initiate the process of creating a new WebAuthn registration. After calling this endpoint, the browser will need to
     * call [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) with the data from
     * [public_key_credential_creation_options](https://w3c.github.io/webauthn/#dictionary-makecredentialoptions) passed to
     * the [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) request via the public
     * key argument. We recommend using the `create()` wrapper provided by the webauthn-json library.
     *
     * If you are not using the [webauthn-json](https://github.com/github/webauthn-json) library, the
     * `public_key_credential_creation_options` will need to be converted to a suitable public key by unmarshalling the JSON,
     * base64 decoding the user ID field, and converting user ID and the challenge fields into an array buffer.
     */
    public fun registerStart(data: RegisterStartRequest, callback: (StytchResult<RegisterStartResponse>) -> Unit)

    /**
     * Complete the creation of a WebAuthn registration by passing the response from the
     * [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) request to this endpoint as
     * the `public_key_credential` parameter.
     *
     * If the [webauthn-json](https://github.com/github/webauthn-json) library's `create()` method was used, the response can
     * be passed directly to the [register endpoint](https://stytch.com/docs/api/webauthn-register). If not, some fields (the
     * client data and the attestation object) from the
     * [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) response will need to be
     * converted from array buffers to strings and marshalled into JSON.
     */
    public suspend fun register(data: RegisterRequest): StytchResult<RegisterResponse>

    /**
     * Complete the creation of a WebAuthn registration by passing the response from the
     * [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) request to this endpoint as
     * the `public_key_credential` parameter.
     *
     * If the [webauthn-json](https://github.com/github/webauthn-json) library's `create()` method was used, the response can
     * be passed directly to the [register endpoint](https://stytch.com/docs/api/webauthn-register). If not, some fields (the
     * client data and the attestation object) from the
     * [navigator.credentials.create()](https://www.w3.org/TR/webauthn-2/#sctn-createCredential) response will need to be
     * converted from array buffers to strings and marshalled into JSON.
     */
    public fun register(data: RegisterRequest, callback: (StytchResult<RegisterResponse>) -> Unit)

    /**
     * Initiate the authentication of a WebAuthn registration. After calling this endpoint, the browser will need to call
     * [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) with the data from
     * `public_key_credential_request_options` passed to the
     * [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) request via the public key argument.
     * We recommend using the `get()` wrapper provided by the webauthn-json library.
     *
     * If you are not using the [webauthn-json](https://github.com/github/webauthn-json) library, `the
     * public_key_credential_request_options` will need to be converted to a suitable public key by unmarshalling the JSON and
     * converting some the fields to array buffers.
     */
    public suspend fun authenticateStart(data: AuthenticateStartRequest): StytchResult<AuthenticateStartResponse>

    /**
     * Initiate the authentication of a WebAuthn registration. After calling this endpoint, the browser will need to call
     * [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) with the data from
     * `public_key_credential_request_options` passed to the
     * [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) request via the public key argument.
     * We recommend using the `get()` wrapper provided by the webauthn-json library.
     *
     * If you are not using the [webauthn-json](https://github.com/github/webauthn-json) library, `the
     * public_key_credential_request_options` will need to be converted to a suitable public key by unmarshalling the JSON and
     * converting some the fields to array buffers.
     */
    public fun authenticateStart(data: AuthenticateStartRequest, callback: (StytchResult<AuthenticateStartResponse>) -> Unit)

    /**
     * Complete the authentication of a WebAuthn registration by passing the response from the
     * [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) request to the authenticate
     * endpoint.
     *
     * If the [webauthn-json](https://github.com/github/webauthn-json) library's `get()` method was used, the response can be
     * passed directly to the [authenticate endpoint](https://stytch.com/docs/api/webauthn-authenticate). If not some fields
     * from the [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) response will need to be
     * converted from array buffers to strings and marshalled into JSON.
     */
    public suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse>

    /**
     * Complete the authentication of a WebAuthn registration by passing the response from the
     * [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) request to the authenticate
     * endpoint.
     *
     * If the [webauthn-json](https://github.com/github/webauthn-json) library's `get()` method was used, the response can be
     * passed directly to the [authenticate endpoint](https://stytch.com/docs/api/webauthn-authenticate). If not some fields
     * from the [navigator.credentials.get()](https://www.w3.org/TR/webauthn-2/#sctn-getAssertion) response will need to be
     * converted from array buffers to strings and marshalled into JSON.
     */
    public fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit)
}

internal class WebAuthnImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : WebAuthn {

    private val moshi = Moshi.Builder().build()

    override suspend fun registerStart(data: RegisterStartRequest): StytchResult<RegisterStartResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(RegisterStartRequest::class.java).toJson(data)
        httpClient.post("/v1/webauthn/register/start", asJson)
    }

    override fun registerStart(data: RegisterStartRequest, callback: (StytchResult<RegisterStartResponse>) -> Unit) {
        coroutineScope.launch {
            callback(registerStart(data))
        }
    }
    override suspend fun register(data: RegisterRequest): StytchResult<RegisterResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(RegisterRequest::class.java).toJson(data)
        httpClient.post("/v1/webauthn/register", asJson)
    }

    override fun register(data: RegisterRequest, callback: (StytchResult<RegisterResponse>) -> Unit) {
        coroutineScope.launch {
            callback(register(data))
        }
    }
    override suspend fun authenticateStart(data: AuthenticateStartRequest): StytchResult<AuthenticateStartResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateStartRequest::class.java).toJson(data)
        httpClient.post("/v1/webauthn/authenticate/start", asJson)
    }

    override fun authenticateStart(data: AuthenticateStartRequest, callback: (StytchResult<AuthenticateStartResponse>) -> Unit) {
        coroutineScope.launch {
            callback(authenticateStart(data))
        }
    }
    override suspend fun authenticate(data: AuthenticateRequest): StytchResult<AuthenticateResponse> = withContext(Dispatchers.IO) {
        val asJson = moshi.adapter(AuthenticateRequest::class.java).toJson(data)
        httpClient.post("/v1/webauthn/authenticate", asJson)
    }

    override fun authenticate(data: AuthenticateRequest, callback: (StytchResult<AuthenticateResponse>) -> Unit) {
        coroutineScope.launch {
            callback(authenticate(data))
        }
    }
}

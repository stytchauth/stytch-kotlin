package com.stytch.java.b2b.api.otp

// !!!
// WARNING: This file is autogenerated
// Only modify code within MANUAL() sections
// or your changes may be overwritten later!
// !!!

import com.squareup.moshi.Moshi
import com.stytch.java.b2b.api.otpsms.Sms
import com.stytch.java.b2b.api.otpsms.SmsImpl
import com.stytch.java.common.InstantAdapter
import com.stytch.java.http.HttpClient
import kotlinx.coroutines.CoroutineScope
public interface OTPs {
    public val sms: Sms
}

internal class OTPsImpl(
    private val httpClient: HttpClient,
    private val coroutineScope: CoroutineScope,
) : OTPs {

    private val moshi = Moshi.Builder().add(InstantAdapter()).build()

    override val sms: Sms = SmsImpl(httpClient, coroutineScope)
}

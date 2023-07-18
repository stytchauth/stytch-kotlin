package com.stytch.kotlin.common

import org.junit.Test

internal class ConstantsTest {
    @Test
    fun `Constants are as expected`() {
        assert(SDK_NAME == "Stytch Kotlin v$VERSION")
        assert(BASE_TEST_URL == "https://test.stytch.com")
        assert(BASE_LIVE_URL == "https://api.stytch.com")
    }
}

package io.jonathanlee.registrationservice.helpers

import org.apache.commons.lang3.RandomStringUtils

abstract class TokenHelper {

    companion object {
        private const val DEFAULT_TOKEN_LENGTH = 56

        private const val DEFAULT_TOKEN_EXPIRY_TIME_MINUTES: Long = 15

        fun getDefaultTokenLength(): Int {
            return DEFAULT_TOKEN_LENGTH
        }

        fun getDefaultTokenExpiryTimeMinutes(): Long {
            return DEFAULT_TOKEN_EXPIRY_TIME_MINUTES
        }

        fun generateTokenValue(tokenLength: Int): String {
            return RandomStringUtils.randomAlphanumeric(tokenLength)
        }
    }

}

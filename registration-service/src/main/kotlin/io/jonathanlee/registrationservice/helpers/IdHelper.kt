package io.jonathanlee.registrationservice.helpers

import org.apache.commons.lang3.RandomStringUtils

abstract class IdHelper {

    companion object {
        private const val DEFAULT_ID_LENGTH = 24

        fun getDefaultIdLength(): Int {
            return DEFAULT_ID_LENGTH
        }

        fun generateId(idLength: Int): String {
            return RandomStringUtils.randomAlphanumeric(idLength)
        }
    }

}

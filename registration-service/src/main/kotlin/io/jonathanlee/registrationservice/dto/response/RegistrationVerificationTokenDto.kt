package io.jonathanlee.registrationservice.dto.response

import java.time.Instant

data class RegistrationVerificationTokenDto(
    val id: String,
    val value: String,
    val userEmail: String,
    val expiryDate: Instant,
)

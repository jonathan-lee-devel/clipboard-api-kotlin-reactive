package io.jonathanlee.registrationservice.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import io.jonathanlee.registrationservice.enums.RegistrationStatus

data class RegistrationStatusDto(
    @field:JsonProperty("registration_status")
    val registrationStatus: RegistrationStatus
)

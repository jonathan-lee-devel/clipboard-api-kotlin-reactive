package io.jonathanlee.registrationservice.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull


data class RegistrationDto(
    @NotNull(message = "E-mail cannot be null")
    val email: String,
    @field:JsonProperty("firstname")
    val firstName: String,
    @field:JsonProperty("lastname")
    val lastName: String,
    val password: String,
    @field:JsonProperty("confirm_password")
    val confirmPassword: String,
)
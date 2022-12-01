package io.jonathanlee.registrationservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @field:Id val id: String,
    val username: String,
    val firstName: String,
    val lastName: String,
    val password: String,
)

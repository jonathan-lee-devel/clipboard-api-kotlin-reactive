package io.jonathanlee.registrationservice.service

import io.jonathanlee.registrationservice.dto.response.RegistrationVerificationTokenDto
import reactor.core.publisher.Mono

interface RegistrationVerificationTokenService {

    fun findByValue(value: Mono<String>): Mono<RegistrationVerificationTokenDto>

    fun generateAndPersistNewToken(userEmail: Mono<String>): Mono<RegistrationVerificationTokenDto>

}

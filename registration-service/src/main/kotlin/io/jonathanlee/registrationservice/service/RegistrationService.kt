package io.jonathanlee.registrationservice.service

import io.jonathanlee.registrationservice.dto.request.RegistrationDto
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto
import reactor.core.publisher.Mono

interface RegistrationService {

    fun registerUser(registrationDto: Mono<RegistrationDto>): Mono<RegistrationStatusDto>

}
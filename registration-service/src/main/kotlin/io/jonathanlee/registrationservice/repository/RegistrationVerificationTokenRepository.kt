package io.jonathanlee.registrationservice.repository

import io.jonathanlee.registrationservice.model.RegistrationVerificationToken
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface RegistrationVerificationTokenRepository : ReactiveMongoRepository<RegistrationVerificationToken, String> {

    fun findByValue(value: Mono<String>): Mono<RegistrationVerificationToken>

}

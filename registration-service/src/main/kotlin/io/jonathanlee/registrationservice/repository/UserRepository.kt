package io.jonathanlee.registrationservice.repository

import io.jonathanlee.registrationservice.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface UserRepository: ReactiveMongoRepository<User, String> {

    fun findByUsername(username: Mono<String>): Mono<User>

}

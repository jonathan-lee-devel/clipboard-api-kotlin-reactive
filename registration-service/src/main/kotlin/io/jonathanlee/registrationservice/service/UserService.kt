package io.jonathanlee.registrationservice.service

import io.jonathanlee.registrationservice.model.User
import reactor.core.publisher.Mono

interface UserService {

    fun findByUsername(username: Mono<String>): Mono<User>

}
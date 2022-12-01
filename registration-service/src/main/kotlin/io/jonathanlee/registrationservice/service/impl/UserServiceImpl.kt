package io.jonathanlee.registrationservice.service.impl

import io.jonathanlee.registrationservice.model.User
import io.jonathanlee.registrationservice.repository.UserRepository
import io.jonathanlee.registrationservice.service.UserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findByUsername(username: Mono<String>): Mono<User> {
        return this.userRepository.findByUsername(username)
    }

}

package io.jonathanlee.registrationservice.service.impl

import io.jonathanlee.registrationservice.dto.request.RegistrationDto
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto
import io.jonathanlee.registrationservice.enums.RegistrationStatus
import io.jonathanlee.registrationservice.service.RegistrationService
import io.jonathanlee.registrationservice.service.UserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RegistrationServiceImpl(private val userService: UserService) : RegistrationService {

    override fun registerUser(registrationDto: Mono<RegistrationDto>): Mono<RegistrationStatusDto> {
        return Mono.just(RegistrationStatusDto(RegistrationStatus.SUCCESS))
    }

}

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
        val user = registrationDto.flatMap {
            return@flatMap this.userService.findByUsername(Mono.just(it.email))
        }

        return user.map {
            println(it.username)
            return@map RegistrationStatusDto(RegistrationStatus.SUCCESS)
        }.switchIfEmpty(Mono.defer {
            return@defer Mono.just(RegistrationStatusDto(RegistrationStatus.FAILURE))
        })
    }

}

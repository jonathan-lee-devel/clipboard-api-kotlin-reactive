package io.jonathanlee.registrationservice.controller

import io.jonathanlee.registrationservice.dto.request.RegistrationDto
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto
import io.jonathanlee.registrationservice.enums.RegistrationStatus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@RequestMapping("/register")
@RestController
class RegisterRestController {

    val log: Logger = LoggerFactory.getLogger(RegisterRestController::class.java)

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    @ResponseStatus(HttpStatus.OK)
    fun register(@Valid @RequestBody registrationDto: Mono<RegistrationDto>): Mono<ResponseEntity<RegistrationStatusDto>> {
        return registrationDto.map {
            println(it.email)
            return@map ResponseEntity.status(HttpStatus.OK)
                .body(RegistrationStatusDto(RegistrationStatus.SUCCESS))
        }
    }

}
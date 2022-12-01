package io.jonathanlee.registrationservice.controller

import io.jonathanlee.registrationservice.dto.request.RegistrationDto
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto
import io.jonathanlee.registrationservice.enums.RegistrationStatus
import io.jonathanlee.registrationservice.service.RegistrationService
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
class RegisterRestController(private val registrationService: RegistrationService) {

    val log: Logger = LoggerFactory.getLogger(RegisterRestController::class.java)

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    @ResponseStatus(HttpStatus.OK)
    fun register(@Valid @RequestBody registrationDto: Mono<RegistrationDto>): Mono<ResponseEntity<RegistrationStatusDto>> {
        return this.registrationService.registerUser(registrationDto).map {
            return@map when (it.registrationStatus) {
                RegistrationStatus.SUCCESS,
                RegistrationStatus.AWAITING_EMAIL_VERIFICATION -> ResponseEntity.status(HttpStatus.OK).body(it)

                RegistrationStatus.USER_ALREADY_EXISTS -> ResponseEntity.status(HttpStatus.CONFLICT).body(it)

                RegistrationStatus.INVALID_TOKEN,
                RegistrationStatus.EMAIL_VERIFICATION_EXPIRED,
                RegistrationStatus.PASSWORDS_DO_NOT_MATCH -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(it)

                else -> {
                    log.error("Internal server error with non-empty mono at POST /register")
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(it)
                }
            }
        }.switchIfEmpty(Mono.defer {
            log.error("Internal server error caused by empty mono at POST /register")
            return@defer Mono.just(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(RegistrationStatusDto(RegistrationStatus.FAILURE))
            )
        })
    }

}
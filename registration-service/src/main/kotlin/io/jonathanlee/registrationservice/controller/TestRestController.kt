package io.jonathanlee.registrationservice.controller

import io.jonathanlee.registrationservice.dto.response.RegistrationVerificationTokenDto
import io.jonathanlee.registrationservice.service.RegistrationVerificationTokenService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/test")
class TestRestController(private val registrationVerificationTokenService: RegistrationVerificationTokenService) {

    @GetMapping("/{userEmail}")
    @ResponseStatus(HttpStatus.OK)
    fun getNewToken(@PathVariable userEmail: String): Mono<ResponseEntity<RegistrationVerificationTokenDto>> {
        val token = this.registrationVerificationTokenService.generateAndPersistNewToken(Mono.just(userEmail)).map {
            return@map it
        }

        return token.map {
            return@map ResponseEntity.status(HttpStatus.OK).body(it)
        }
    }

}
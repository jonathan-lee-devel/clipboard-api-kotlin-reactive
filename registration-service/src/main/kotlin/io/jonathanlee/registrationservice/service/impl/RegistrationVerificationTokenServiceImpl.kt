package io.jonathanlee.registrationservice.service.impl

import io.jonathanlee.registrationservice.dto.response.RegistrationVerificationTokenDto
import io.jonathanlee.registrationservice.helpers.IdHelper
import io.jonathanlee.registrationservice.helpers.TokenHelper
import io.jonathanlee.registrationservice.model.RegistrationVerificationToken
import io.jonathanlee.registrationservice.repository.RegistrationVerificationTokenRepository
import io.jonathanlee.registrationservice.service.RegistrationVerificationTokenService
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.ZonedDateTime

@Service
class RegistrationVerificationTokenServiceImpl(
    private val registrationVerificationTokenRepository: RegistrationVerificationTokenRepository,
): RegistrationVerificationTokenService {

    override fun findByValue(value: Mono<String>): Mono<RegistrationVerificationTokenDto> {
        return this.registrationVerificationTokenRepository.findByValue(value)
            .map {
                return@map RegistrationVerificationTokenDto(
                    it.id,
                    it.value,
                    it.userEmail,
                    it.expiryDate
                )
            }
    }

    override fun generateAndPersistNewToken(userEmail: Mono<String>): Mono<RegistrationVerificationTokenDto> {
        val newToken = userEmail.map {
            return@map RegistrationVerificationToken(
                ObjectId.get(),
                IdHelper.generateId(IdHelper.getDefaultIdLength()),
                TokenHelper.generateTokenValue(TokenHelper.getDefaultTokenLength()),
                it,
                ZonedDateTime.now().plusMinutes(TokenHelper.getDefaultTokenExpiryTimeMinutes()).toInstant(),
            )
        }

        return newToken.flatMap { registrationVerificationToken ->
            return@flatMap this.registrationVerificationTokenRepository.save(registrationVerificationToken)
                .map { savedRegistrationVerificationToken ->
                    return@map RegistrationVerificationTokenDto(
                        savedRegistrationVerificationToken.id,
                        savedRegistrationVerificationToken.value,
                        savedRegistrationVerificationToken.userEmail,
                        savedRegistrationVerificationToken.expiryDate
                    )
                }
        }
    }

}

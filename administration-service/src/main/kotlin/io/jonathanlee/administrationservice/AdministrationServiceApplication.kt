package io.jonathanlee.administrationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdministrationServiceApplication

fun main(args: Array<String>) {
	runApplication<AdministrationServiceApplication>(*args)
}

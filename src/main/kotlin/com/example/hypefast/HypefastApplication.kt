package com.example.hypefast

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class HypefastApplication

fun main(args: Array<String>) {
	runApplication<HypefastApplication>(*args)
}

package com.aaamarkin.birmo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BirmoGcloudApplication

fun main(args: Array<String>) {
	runApplication<BirmoGcloudApplication>(*args)
}

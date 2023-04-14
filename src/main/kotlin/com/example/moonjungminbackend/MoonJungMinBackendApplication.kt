package com.example.moonjungminbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MoonJungMinBackendApplication

fun main(args: Array<String>) {
    runApplication<MoonJungMinBackendApplication>(*args)
}
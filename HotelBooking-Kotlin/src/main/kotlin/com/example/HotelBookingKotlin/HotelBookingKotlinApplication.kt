package com.example.HotelBookingKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.example.HotelBookingKotlin")
class HotelBookingKotlinApplication

fun main(args: Array<String>) {
    runApplication<HotelBookingKotlinApplication>(*args)
}

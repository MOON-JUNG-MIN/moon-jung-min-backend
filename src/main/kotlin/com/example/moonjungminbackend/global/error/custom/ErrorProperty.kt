package com.example.moonjungminbackend.global.error.custom

interface ErrorProperty {
    fun status(): Int
    fun message(): String
}
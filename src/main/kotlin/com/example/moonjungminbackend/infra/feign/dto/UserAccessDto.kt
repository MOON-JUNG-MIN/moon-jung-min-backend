package com.example.moonjungminbackend.infra.feign.dto

data class UserAccessDto (

        val accessToken: String,
        val expiresIn: Int,
        val scope: String,
        val tokenType: String,
        val idToken: String

)

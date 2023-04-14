package com.example.moonjungminbackend.infra.feign.dto

data class UserInfoDto (

        val id: String,
        val email: String,
        val name: String,
        val picture: String,
        val locale: String

)

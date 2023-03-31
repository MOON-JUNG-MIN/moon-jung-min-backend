package com.example.moonjungminbackend.global.error.custom

import org.springframework.http.HttpStatus

enum class ErrorCode (
        val status: HttpStatus,
        val message: String
) {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찿지 못함"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러");
}
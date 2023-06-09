package com.example.moonjungminbackend.global.error.custom

import org.springframework.http.HttpStatus

enum class ErrorCode (
        private val status: HttpStatus,
        private val message: String
) : ErrorProperty {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찿지 못함"),
    BUCKET_NOT_FOUND(HttpStatus.NOT_FOUND, "버킷을 찾지 못함"),

    MEMBER_EXIST(HttpStatus.CONFLICT, "멤버가 이미 존재함"),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "멤버를 찾지 못함"),

    INVALID_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED, "토큰 인증 오류"),
    EXPIRED_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED, "토큰 만료"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러");

    override fun status() = status.value()
    override fun message() = message
}
package com.example.moonjungminbackend.global.error.custom

import org.springframework.web.bind.MethodArgumentNotValidException

class ErrorResponse<T> (
        val status: Int,
        val message: String
) {
    companion object {
        fun custom(e: CustomException):ErrorResponse<Unit> = ErrorResponse(
                status = e.status,
                message = e.errorMessage
        )

        fun valid(status: Int, message: String):ErrorResponse<Unit> = ErrorResponse(
                status = status,
                message = message
        )
    }
}
package com.example.moonjungminbackend.global.error.custom

import org.springframework.web.bind.MethodArgumentNotValidException

class ErrorResponse (
        val status: Int,
        val message: String
) {
    companion object {
        fun custom(e: CustomException) = ErrorResponse(
                status = e.status,
                message = e.errorMessage
        )

        fun valid(status: Int, message: String) = ErrorResponse(
                status = status,
                message = message
        )
    }
}
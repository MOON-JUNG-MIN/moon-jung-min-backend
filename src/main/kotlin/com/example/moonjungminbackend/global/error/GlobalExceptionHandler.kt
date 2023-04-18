package com.example.moonjungminbackend.global.error

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun custom(e: CustomException): ResponseEntity<ErrorResponse<Unit>> {
        return ResponseEntity(
                ErrorResponse.custom(e), HttpStatus.valueOf(e.status)
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun valid(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse<Unit>> {
        return ResponseEntity(
                ErrorResponse.valid(400, "BAD REQUEST"), HttpStatus.valueOf(400)
        )
    }
}
package com.example.moonjungminbackend.global.error.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object ExpiredJwtException : CustomException(ErrorCode.EXPIRED_JWT_EXCEPTION) {
    val EXCEPTION = ExpiredJwtException
}
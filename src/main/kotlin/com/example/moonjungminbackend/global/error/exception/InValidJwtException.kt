package com.example.moonjungminbackend.global.error.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object InValidJwtException : CustomException(ErrorCode.INVALID_JWT_EXCEPTION) {
    val EXCEPTION = InValidJwtException
}
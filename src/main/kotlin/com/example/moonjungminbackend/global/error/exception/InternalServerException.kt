package com.example.moonjungminbackend.global.error.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object InternalServerException : CustomException(ErrorCode.INTERNAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerException
}
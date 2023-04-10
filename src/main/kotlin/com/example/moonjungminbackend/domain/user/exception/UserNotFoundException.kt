package com.example.moonjungminbackend.domain.user.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND) {
    val EXCEPTION = UserNotFoundException
}
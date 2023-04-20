package com.example.moonjungminbackend.domain.member.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object MemberExistException : CustomException(ErrorCode.MEMBER_EXIST) {
    val EXCEPTION = MemberExistException
}
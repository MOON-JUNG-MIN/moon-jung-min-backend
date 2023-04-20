package com.example.moonjungminbackend.domain.member.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object MemberNotFoundException : CustomException(ErrorCode.MEMBER_NOT_FOUND) {
    val EXCEPTION = MemberExistException
}
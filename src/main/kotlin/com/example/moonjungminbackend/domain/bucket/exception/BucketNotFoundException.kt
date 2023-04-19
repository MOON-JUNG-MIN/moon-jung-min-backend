package com.example.moonjungminbackend.domain.bucket.exception

import com.example.moonjungminbackend.global.error.custom.CustomException
import com.example.moonjungminbackend.global.error.custom.ErrorCode

object BucketNotFoundException : CustomException(ErrorCode.BUCKET_NOT_FOUND) {
    val EXCEPTION = BucketNotFoundException
}
package com.example.moonjungminbackend.domain.bucket.controller.dto

import java.util.Date

data class BucketUpdateRequest(
        val title: String,
        val content: String,
        val image: String,
        val targetDate: Date
)

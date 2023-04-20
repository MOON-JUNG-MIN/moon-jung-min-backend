package com.example.moonjungminbackend.domain.bucket.controller.dto

import java.time.LocalDateTime
import java.util.Date

data class MyBucketResponse (
        val id: Long,
        val title: String,
        val content: String,
        val image: String,
        val targetDate: Date,
        val isEnd: Boolean,
        val startDate: LocalDateTime,
        val members: List<String>
)

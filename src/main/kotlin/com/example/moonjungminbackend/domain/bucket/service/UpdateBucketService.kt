package com.example.moonjungminbackend.domain.bucket.service

import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketUpdateRequest
import com.example.moonjungminbackend.domain.bucket.domain.repository.BucketRepository
import com.example.moonjungminbackend.domain.bucket.exception.BucketNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateBucketService (
        private val bucketRepository: BucketRepository
) {

    @Transactional
    fun execute(id: Long, request: BucketUpdateRequest) {
        val bucket = bucketRepository.findBucketById(id) ?: throw BucketNotFoundException.EXCEPTION

        bucket.update(
                request.title,
                request.content,
                request.image,
                request.targetDate
        )
    }
}
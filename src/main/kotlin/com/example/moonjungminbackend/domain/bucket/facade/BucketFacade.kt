package com.example.moonjungminbackend.domain.bucket.facade

import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import com.example.moonjungminbackend.domain.bucket.domain.repository.BucketRepository
import com.example.moonjungminbackend.domain.bucket.exception.BucketNotFoundException
import org.springframework.stereotype.Component

@Component
class BucketFacade (
        private val bucketRepository: BucketRepository
) {

    fun findById(id: Long): Bucket {
        return bucketRepository.findBucketById(id) ?: throw BucketNotFoundException.EXCEPTION
    }
}
package com.example.moonjungminbackend.domain.bucket.service

import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketCreateRequest
import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import com.example.moonjungminbackend.domain.bucket.domain.repository.BucketRepository
import com.example.moonjungminbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CreateBucketService (
        private val bucketRepository: BucketRepository,
        private val userFacade: UserFacade
) {

    fun execute(request: BucketCreateRequest) {
        bucketRepository.save(
                Bucket(
                        title = request.title,
                        content = request.content,
                        image = request.image,
                        targetDate = request.targetDate,
                        isEnd = false,
                        user = userFacade.getCurrentUser()
                )
        )
    }

}
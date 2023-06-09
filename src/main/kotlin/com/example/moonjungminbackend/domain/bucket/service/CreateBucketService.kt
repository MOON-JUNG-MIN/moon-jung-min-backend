package com.example.moonjungminbackend.domain.bucket.service

import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketCreateRequest
import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import com.example.moonjungminbackend.domain.bucket.domain.repository.BucketRepository
import com.example.moonjungminbackend.domain.member.domain.Member
import com.example.moonjungminbackend.domain.member.domain.repository.MemberRepository
import com.example.moonjungminbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateBucketService (
        private val bucketRepository: BucketRepository,
        private val memberRepository: MemberRepository,
        private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(request: BucketCreateRequest) {
        val user = userFacade.getCurrentUser()
        val bucket = bucketRepository.save(
                Bucket(
                        title = request.title,
                        content = request.content,
                        image = request.image,
                        targetDate = request.targetDate,
                        isEnd = false,
                        user = user
                )
        )

        memberRepository.save(
                Member(
                        bucket = bucket,
                        user = user
                )
        )
    }

}
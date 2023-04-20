package com.example.moonjungminbackend.domain.bucket.service

import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketUpdateRequest
import com.example.moonjungminbackend.domain.bucket.domain.repository.BucketRepository
import com.example.moonjungminbackend.domain.bucket.exception.BucketNotFoundException
import com.example.moonjungminbackend.domain.bucket.facade.BucketFacade
import com.example.moonjungminbackend.domain.member.domain.repository.MemberRepository
import com.example.moonjungminbackend.domain.member.exception.MemberNotFoundException
import com.example.moonjungminbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class UpdateBucketService (
        private val bucketFacade: BucketFacade,
        private val memberRepository: MemberRepository,
        private val userFacade: UserFacade
) {

    @Transactional
    fun execute(id: Long, request: BucketUpdateRequest) {
        val bucket = bucketFacade.findById(id)

        val user = userFacade.getCurrentUser()

        val members = memberRepository.findMembersByBucket(bucket).stream().map { it.user }.collect(Collectors.toList())

        if(!members.contains(user)) {
            throw MemberNotFoundException.EXCEPTION
        }

        bucket.update(
                request.title,
                request.content,
                request.image,
                request.targetDate
        )
    }
}
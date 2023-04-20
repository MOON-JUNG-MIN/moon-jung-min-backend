package com.example.moonjungminbackend.domain.bucket.service

import com.example.moonjungminbackend.domain.bucket.controller.dto.MyBucketListResponse
import com.example.moonjungminbackend.domain.bucket.controller.dto.MyBucketResponse
import com.example.moonjungminbackend.domain.member.domain.repository.MemberRepository
import com.example.moonjungminbackend.domain.member.facade.MemberFacade
import com.example.moonjungminbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class MyBucketService (
        private val memberRepository: MemberRepository,
        private val userFacade: UserFacade,
        private val memberFacade: MemberFacade
) {

    @Transactional(readOnly = true)
    fun execute(): MyBucketListResponse {
        val user = userFacade.getCurrentUser()

        val buckets = memberRepository.findMembersByUser(user)
                .stream()
                .map {
                    val cnt = it.bucket
                    MyBucketResponse (
                            id = it.bucket.id,
                            title = cnt.title,
                            content = cnt.content,
                            image = cnt.image,
                            targetDate = cnt.targetDate,
                            isEnd = cnt.isEnd,
                            startDate = cnt.createdAt,
                            members = memberFacade.findUsersByBucket(cnt)
                    )
                }.collect(Collectors.toList())

        return MyBucketListResponse(
                buckets
        )
    }
}
package com.example.moonjungminbackend.domain.member.facade

import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import com.example.moonjungminbackend.domain.member.domain.repository.MemberRepository
import org.springframework.stereotype.Component
import java.util.stream.Collector
import java.util.stream.Collectors

@Component
class MemberFacade (
        private val memberRepository: MemberRepository
) {

    fun findUsersByBucket(bucket: Bucket): List<String> {
        val users = memberRepository.findMembersByBucket(bucket).stream()
                .map {
                    it.user.nickname
                }.collect(Collectors.toList())

        return users
    }
}
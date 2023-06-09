package com.example.moonjungminbackend.domain.member.service

import com.example.moonjungminbackend.domain.bucket.domain.repository.BucketRepository
import com.example.moonjungminbackend.domain.bucket.exception.BucketNotFoundException
import com.example.moonjungminbackend.domain.member.domain.Member
import com.example.moonjungminbackend.domain.member.domain.repository.MemberRepository
import com.example.moonjungminbackend.domain.member.exception.MemberExistException
import com.example.moonjungminbackend.domain.member.present.dto.MemberAddRequest
import com.example.moonjungminbackend.domain.user.domain.repository.UserRepository
import com.example.moonjungminbackend.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberAddService (
        private val memberRepository: MemberRepository,
        private val userRepository: UserRepository,
        private val bucketRepository: BucketRepository
) {

    @Transactional(readOnly = true)
    fun execute(id: Long, request: MemberAddRequest) {
        val bucket = bucketRepository.findBucketById(id) ?: throw BucketNotFoundException.EXCEPTION
        val user = userRepository.findUserByEmail(request.email) ?: throw UserNotFoundException.EXCEPTION

        memberRepository.findMemberByUser(user)?.let {
            throw MemberExistException.EXCEPTION
        }

        memberRepository.save(
                Member(
                        bucket = bucket,
                        user = user
                )
        )

    }

}
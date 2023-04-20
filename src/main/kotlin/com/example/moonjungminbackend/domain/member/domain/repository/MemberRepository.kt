package com.example.moonjungminbackend.domain.member.domain.repository

import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import com.example.moonjungminbackend.domain.member.domain.Member
import com.example.moonjungminbackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, Long> {
    fun findMembersByUser(user: User): List<Member>

    fun findMembersByBucket(bucket: Bucket): List<Member>

    fun findMemberByUser(user: User): Member?
}
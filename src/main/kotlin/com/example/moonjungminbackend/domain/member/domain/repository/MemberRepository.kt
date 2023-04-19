package com.example.moonjungminbackend.domain.member.domain.repository

import com.example.moonjungminbackend.domain.member.domain.Member
import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, Long> {
}
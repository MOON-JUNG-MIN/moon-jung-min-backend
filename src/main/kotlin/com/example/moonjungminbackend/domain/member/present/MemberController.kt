package com.example.moonjungminbackend.domain.member.present

import com.example.moonjungminbackend.domain.member.present.dto.MemberAddRequest
import com.example.moonjungminbackend.domain.member.service.MemberAddService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController (
        private val memberAddService: MemberAddService
) {

    @PostMapping("/{id}")
    fun add(@PathVariable("id") id: Long, @RequestBody request: MemberAddRequest) {
        memberAddService.execute(id, request)
    }
}
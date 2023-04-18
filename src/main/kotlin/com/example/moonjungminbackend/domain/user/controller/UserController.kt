package com.example.moonjungminbackend.domain.user.controller

import com.example.moonjungminbackend.domain.user.controller.dto.CodeRequest
import com.example.moonjungminbackend.domain.user.controller.dto.TokenResponse
import com.example.moonjungminbackend.domain.user.service.LoginService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
        private val loginService: LoginService
) {

    @PostMapping("/login")
    fun login(@RequestBody codeRequest: CodeRequest):TokenResponse {
        return loginService.login(codeRequest)
    }

}
package com.example.moonjungminbackend.domain.user.service

import com.example.moonjungminbackend.domain.user.controller.dto.CodeRequest
import com.example.moonjungminbackend.domain.user.controller.dto.TokenResponse
import com.example.moonjungminbackend.domain.user.domain.User
import com.example.moonjungminbackend.domain.user.domain.repository.UserRepository
import com.example.moonjungminbackend.global.properties.ClientProperties
import com.example.moonjungminbackend.global.security.jwt.JwtProvider
import com.example.moonjungminbackend.infra.feign.client.AccessTokenClient
import com.example.moonjungminbackend.infra.feign.client.UserInfoClient
import org.springframework.stereotype.Service

@Service
class LoginService (
        private val userRepository: UserRepository,
        private val accessTokenClient: AccessTokenClient,
        private val userInfoClient: UserInfoClient,
        private val clientProperties: ClientProperties,
        private val jwtProvider: JwtProvider
) {

    fun login(codeRequest: CodeRequest): TokenResponse {

        val access = accessTokenClient.access(
                code = codeRequest.code,
                clientId = clientProperties.clientId,
                clientSecret = clientProperties.clientSecret,
                redirectUri = clientProperties.redirectUri,
                grantType = clientProperties.authorizationGrantType
        )

        val token = "Bearer ${access.accessToken}"

        val user = userInfoClient.info(
                token
        )

        userRepository.findUserByEmail(user.email)?.let {
            return TokenResponse(
                    jwtProvider.getToken(it.email).accessToken
            )
        }

        val one = userRepository.save(
                User(
                        nickname = user.name,
                        email = user.email,
                        profileImage = user.picture
                )
        )

        return TokenResponse(
                jwtProvider.getToken(one.email).accessToken
        )

    }

}
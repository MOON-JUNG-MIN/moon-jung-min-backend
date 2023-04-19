package com.example.moonjungminbackend.domain.user.facade

import com.example.moonjungminbackend.domain.user.domain.User
import com.example.moonjungminbackend.domain.user.domain.repository.UserRepository
import com.example.moonjungminbackend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade (
        private val userRepository: UserRepository
) {

    fun getCurrentUser():User {
        val name = SecurityContextHolder.getContext().authentication.name
        return userRepository.findUserByEmail(name) ?: throw UserNotFoundException.EXCEPTION
    }
}
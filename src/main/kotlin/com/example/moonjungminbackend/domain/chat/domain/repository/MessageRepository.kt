package com.example.moonjungminbackend.domain.chat.domain.repository

import com.example.moonjungminbackend.domain.chat.domain.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : CrudRepository<Message, Long> {
}
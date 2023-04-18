package com.example.moonjungminbackend.domain.chat.domain.repository

import com.example.moonjungminbackend.domain.chat.domain.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : CrudRepository<Room, Long> {
}
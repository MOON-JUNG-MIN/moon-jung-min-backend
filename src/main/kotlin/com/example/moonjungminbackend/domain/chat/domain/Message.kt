package com.example.moonjungminbackend.domain.chat.domain

import com.example.moonjungminbackend.domain.user.domain.User
import com.example.moonjungminbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_chat")
data class Message (

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(500)")
        val content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "room_id", nullable = false)
        val room: Room

) : BaseEntity() {
}
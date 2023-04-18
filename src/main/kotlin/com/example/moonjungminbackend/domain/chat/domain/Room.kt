package com.example.moonjungminbackend.domain.chat.domain

import com.example.moonjungminbackend.domain.user.domain.User
import com.example.moonjungminbackend.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_room")
data class Room (

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User

) : BaseEntity()
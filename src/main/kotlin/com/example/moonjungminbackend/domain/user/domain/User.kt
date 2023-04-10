package com.example.moonjungminbackend.domain.user.domain

import com.example.moonjungminbackend.global.entity.BaseEntity
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class User (

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(50)")
        val email: String,

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(50)")
        val nickname: String,

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(200)")
        val profileImage: String,

        @field:NotNull
        val createDate: Date

) : BaseEntity() {
}
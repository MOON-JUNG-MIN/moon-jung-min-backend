package com.example.moonjungminbackend.domain.bucket.domain

import com.example.moonjungminbackend.global.entity.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_bucket")
data class Bucket(

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(100)")
        val title: String,

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(500)")
        val content: String,

        @field:NotNull
        @field:Column(columnDefinition = "VARCHAR(200)")
        val image: String

) : BaseEntity()
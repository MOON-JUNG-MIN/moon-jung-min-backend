package com.example.moonjungminbackend.domain.member.domain

import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import com.example.moonjungminbackend.domain.user.domain.User
import com.example.moonjungminbackend.global.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "tbl_member")
data class Member (

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "bucket_id", nullable = false)
        val bucket: Bucket

) : BaseEntity()
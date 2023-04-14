package com.example.moonjungminbackend.domain.bucket.domain.repository

import com.example.moonjungminbackend.domain.bucket.domain.Bucket
import org.springframework.data.repository.CrudRepository

interface BucketRepository : CrudRepository<Bucket, Long> {
}
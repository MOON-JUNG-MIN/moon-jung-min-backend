package com.example.moonjungminbackend.domain.bucket.controller

import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketCreateRequest
import com.example.moonjungminbackend.domain.bucket.service.CreateBucketService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bucket")
class BucketController (
        private val createBucketService: CreateBucketService
) {

    @PostMapping
    fun create(@RequestBody request: BucketCreateRequest) {
        createBucketService.execute(request)
    }

}
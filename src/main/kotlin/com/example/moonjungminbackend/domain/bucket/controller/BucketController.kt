package com.example.moonjungminbackend.domain.bucket.controller

import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketCreateRequest
import com.example.moonjungminbackend.domain.bucket.controller.dto.BucketUpdateRequest
import com.example.moonjungminbackend.domain.bucket.controller.dto.MyBucketListResponse
import com.example.moonjungminbackend.domain.bucket.service.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bucket")
class BucketController (
        private val createBucketService: CreateBucketService,
        private val updateBucketService: UpdateBucketService,
        private val deleteBucketService: DeleteBucketService,
        private val completeBucketService: CompleteBucketService,
        private val myBucketService: MyBucketService
) {

    @GetMapping
    fun read(): MyBucketListResponse {
        return myBucketService.execute()
    }

    @PostMapping
    fun create(@RequestBody request: BucketCreateRequest) {
        createBucketService.execute(request)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: BucketUpdateRequest) {
        updateBucketService.execute(id, request)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        deleteBucketService.execute(id)
    }

    @PutMapping("/end/{id}")
    fun end(@PathVariable("id") id: Long) {
        completeBucketService.execute(id)
    }

}
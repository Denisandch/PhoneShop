package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.repository.Repository

class CacheData(
    private val repository: Repository
) {
    suspend fun cacheData(data: List<Phone>) {
        repository.cacheData(data)
    }
}
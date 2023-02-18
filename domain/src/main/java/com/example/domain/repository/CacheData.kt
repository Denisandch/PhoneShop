package com.example.domain.repository

import com.example.domain.model.Phone

interface CacheData {
    suspend fun cacheData(data: List<Phone>)
}
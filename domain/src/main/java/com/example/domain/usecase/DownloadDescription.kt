package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

class DownloadDescription(
    private val repository: Repository
) {
    suspend fun getDescription(phoneID: String): PhoneDescription {
        return repository.getDescription(phoneID)
    }
}
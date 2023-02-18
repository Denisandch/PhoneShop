package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.repository.Repository

class DownloadPhones(
    private val repository: Repository
) {
    suspend fun getPhoneList(): List<Phone> {
        return repository.getPhoneList()
    }
}
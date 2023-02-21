package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.datasource.MutableDataSource

class PhoneDescriptionCachedDataSource(
    private val repository: com.example.domain.repository.Repository
) : MutableDataSource<PhoneDescription> {

    override suspend fun saveData(data: PhoneDescription) {
        repository.savePhoneDescription(data)
    }

    override suspend fun getData(id: Int): PhoneDescription? {
        return repository.getPhoneDescription(id)
    }
}
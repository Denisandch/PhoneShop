package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.datasource.DataSource

class PhoneDescriptionCloudDataSource(
    private val repository: com.example.domain.repository.Repository
) : DataSource<PhoneDescription> {
    override suspend fun getData(id: Int): PhoneDescription {
        return repository.downloadPhoneDescription(id)
    }
}
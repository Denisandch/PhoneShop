package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.datasource.DataSource

class PhoneDescriptionCloudDataSource(
    private val repositoryToData: com.example.domain.repository.RepositoryToData
) : DataSource<PhoneDescription> {
    override suspend fun getData(id: Int): PhoneDescription {
        return repositoryToData.downloadPhoneDescription(id)
    }
}
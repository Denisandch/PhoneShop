package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.datasource.DataSource

private const val TO_JSON_ARRAY_NUMBERING = 1

class PhoneDescriptionCloudDataSource(
    private val repositoryToData: com.example.domain.repository.RepositoryToData
) : DataSource<PhoneDescription> {
    override suspend fun getData(id: Int): PhoneDescription {
        return repositoryToData.downloadPhoneDescription(id - TO_JSON_ARRAY_NUMBERING)
    }
}
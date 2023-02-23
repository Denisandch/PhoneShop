package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.datasource.MutableDataSource

class PhoneDescriptionCachedDataSource(
    private val repositoryToData: com.example.domain.repository.RepositoryToData
) : MutableDataSource<PhoneDescription> {

    override suspend fun saveData(data: PhoneDescription) {
        repositoryToData.savePhoneDescription(data)
    }

    override suspend fun getData(id: Int): PhoneDescription? {
        return repositoryToData.getPhoneDescription(id)
    }
}
package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.usecase.datasource.DataSource

class PhoneListCloudDataSource(
    private val repositoryToData: com.example.domain.repository.RepositoryToData
) : DataSource<List<Phone>> {
    override suspend fun getData(id: Int): List<Phone> {
        return repositoryToData.downloadPhoneList()
    }
}
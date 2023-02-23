package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.usecase.datasource.MutableDataSource

class PhoneListCachedDataSource(
    private val repositoryToData: com.example.domain.repository.RepositoryToData
) : MutableDataSource<List<Phone>> {
    override suspend fun saveData(data: List<Phone>) {
        repositoryToData.savePhoneList(data)
    }

    override suspend fun getData(id: Int): List<Phone>? {
        return repositoryToData.getPhoneList()
    }

}
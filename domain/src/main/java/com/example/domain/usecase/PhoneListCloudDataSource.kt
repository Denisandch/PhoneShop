package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.usecase.datasource.DataSource

class PhoneListCloudDataSource(
    private val repository: com.example.domain.repository.Repository
) : DataSource<List<Phone>> {
    override suspend fun getData(id: Int): List<Phone> {
        return repository.downloadPhoneList()
    }
}
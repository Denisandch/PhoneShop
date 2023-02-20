package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.usecase.datasource.MutableDataSource

class PhoneListCachedDataSource(
    private val repository: com.example.domain.repository.Repository
) : MutableDataSource<List<Phone>> {
    override suspend fun saveData(data: List<Phone>) {
        repository.savePhoneList(data)
    }

    override suspend fun getData(id: Int): List<Phone> {
        return repository.getPhoneList()
    }

}
package com.example.domain.usecase.datasource

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

class StorageMutable(private val repository: Repository) : MutableDataSource {

    override suspend fun savePhoneList(data: List<Phone>): Boolean {
        return repository.savePhoneList(data)
    }

    override suspend fun savePhoneDescription(data: PhoneDescription): Boolean {
        return repository.savePhoneDescription(data)
    }

    override suspend fun getPhoneList(): List<Phone> {
        return repository.getPhoneList()
    }

    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription {
        return repository.getPhoneDescription(phoneID)
    }


}
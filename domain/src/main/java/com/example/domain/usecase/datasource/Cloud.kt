package com.example.domain.usecase.datasource

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

class Cloud(private val repository: Repository) : DataSource {

    override suspend fun getPhoneList(): List<Phone> {
        return repository.downloadPhoneList()
    }

    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription {
        return repository.downloadPhoneDescription(phoneID)
    }

}
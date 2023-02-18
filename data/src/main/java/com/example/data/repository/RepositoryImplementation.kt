package com.example.data.repository

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

class RepositoryImplementation(

) : Repository {

    override suspend fun getPhoneList(): List<Phone> {
        TODO("Not yet implemented")
    }

    override suspend fun getDescription(phoneID: String): PhoneDescription {
        TODO("Not yet implemented")
    }

    override suspend fun cacheData(data: List<Phone>) {
        TODO("Not yet implemented")
    }
}
package com.example.domain.usecase.needreview

import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

interface GetData {
    suspend fun getPhoneDescription(phoneID: Int = -1): PhoneDescription
}

class NetworkDataSource(
    private val repository: Repository
) : GetData {
    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription {
        return repository.downloadPhoneDescription(phoneID)
    }
}

class StorageDataSource(
    private val repository: Repository
) : GetData {
    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription {
        return repository.getPhoneDescription(phoneID)
    }
}

class Getter(
    private val network: GetData,
    private val storage: GetData
) : GetData {
    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription {
        var result = storage.getPhoneDescription(phoneID)

        if (result == null) {
            result = network.getPhoneDescription(phoneID)
        }

        return result
    }

}
package com.example.domain.usecase.needreview

import com.example.domain.model.Phone
import com.example.domain.repository.Repository

interface GetPhoneList {
    suspend fun getPhoneList(): List<Phone>
}

class NetworkDataSourcePhone(
    private val repository: Repository
) : GetPhoneList {
    override suspend fun getPhoneList(): List<Phone> {
        return repository.downloadPhoneList()
    }
}

class StorageDataSourcePhone(
    private val repository: Repository
) : GetPhoneList {
    override suspend fun getPhoneList(): List<Phone> {
        return repository.getPhoneList()
    }
}

class GetterPhone(
    private val network: GetPhoneList,
    private val storage: GetPhoneList
) : GetPhoneList {
    override suspend fun getPhoneList(): List<Phone> {
        var result = storage.getPhoneList()

        if (result == null) {
            result = network.getPhoneList()
        }

        return result
    }

}
package com.example.data.repository

import com.example.data.repository.extensions.mappers.mapDataPhoneDescriptionDataToDomain
import com.example.data.repository.extensions.mappers.mapDomainPhoneDescriptionDataToData
import com.example.data.repository.extensions.mappers.mapListDataPhoneToDomain
import com.example.data.repository.extensions.mappers.mapListPhoneToData
import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.network.Network
import com.example.data.repository.storage.Storage
import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

class RepositoryImplementation(
    private val network: Network,
    private val storage: Storage
) : Repository {

    override suspend fun downloadPhoneList(): List<Phone> {
        return network.downloadPhoneList().mapListDataPhoneToDomain()
    }

    override suspend fun downloadPhoneDescription(phoneID: Int): PhoneDescription {
        return network.downloadDescription(phoneID).mapDataPhoneDescriptionDataToDomain()
    }

    override suspend fun savePhoneList(data: List<Phone>): Boolean {
        return storage.savePhoneList(data.mapListPhoneToData())
    }

    override suspend fun savePhoneDescription(data: PhoneDescription): Boolean {
        return storage.savePhoneDescription(data.mapDomainPhoneDescriptionDataToData())
    }

    override suspend fun getPhoneList(): List<Phone>? {
        return storage.getPhoneList()?.mapListDataPhoneToDomain()
    }

    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription? {
        return storage.getDescription(phoneID)?.mapDataPhoneDescriptionDataToDomain()
    }

}

package com.example.data.repository

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.network.Network
import com.example.data.repository.storage.Storage
import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

//TODO update mappers
class RepositoryImplementation(
    private val network: Network,
    private val storage: Storage
) : Repository {

    override suspend fun downloadPhoneList(): List<Phone> {
        val buf = network.downloadPhoneList()
        return mapToPhone(buf)
    }

    override suspend fun downloadPhoneDescription(phoneID: Int): PhoneDescription {
        val buf = network.downloadDescription(phoneID)
        return mapToPhoneDescription(buf)
    }

    override suspend fun savePhoneList(data: List<Phone>): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun savePhoneDescription(data: PhoneDescription): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoneList(): List<Phone> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoneDescription(phoneID: Int): PhoneDescription {
        TODO("Not yet implemented")
    }


    private fun mapToPhone(buf: List<PhoneData>): List<Phone> {

        val mapped = mutableListOf<Phone>()

        for (phone in buf) {
            mapped.add(
                with(phone) {
                    Phone(
                        id, name, price, picture
                    )
                }
            )
        }
        return mapped
    }

    private fun mapToPhoneDescription(buf: PhoneDescriptionData): PhoneDescription {
        return with(buf) {
            PhoneDescription(
                id, name, price, description, pictures
            )
        }
    }
}
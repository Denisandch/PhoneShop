package com.example.data.repository

import com.example.data.repository.model.PhoneJson
import com.example.data.repository.model.PhoneDescriptionJson
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

    override suspend fun getPhoneList(): List<Phone> {
        val buf = network.getPhoneList()
        return mapToPhone(buf)
    }

    override suspend fun getDescription(phoneID: String): PhoneDescription {
        val buf = network.getDescription(phoneID)
        return mapToPhoneDescription(buf)
    }

    override suspend fun cacheData(data: List<Phone>): Boolean {
        TODO("Not yet implemented")
    }

    private fun mapToPhone(buf: List<PhoneJson>): List<Phone> {

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

    private fun mapToPhoneDescription(buf: PhoneDescriptionJson): PhoneDescription {
        return with(buf) {
            PhoneDescription(
                id, name, price, description, pictures
            )
        }
    }
}
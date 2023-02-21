package com.example.domain.repository

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription

interface StorageRepository {
    suspend fun savePhoneList(data: List<Phone>): Boolean

    suspend fun savePhoneDescription(data: PhoneDescription): Boolean

    suspend fun getPhoneList(): List<Phone>?

    suspend fun getPhoneDescription(phoneID: Int): PhoneDescription?
}
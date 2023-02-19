package com.example.domain.repository

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription

interface NetworkRepository {
    suspend fun downloadPhoneList(): List<Phone>
    suspend fun downloadPhoneDescription(phoneID: Int): PhoneDescription

}
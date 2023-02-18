package com.example.domain.repository

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription

interface DownloadRepository {

    suspend fun getPhoneList(): List<Phone>

    suspend fun getDescription(phoneID: String): PhoneDescription
}
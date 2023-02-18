package com.example.data.repository.network

import com.example.data.repository.model.PhoneJson
import com.example.data.repository.model.PhoneDescriptionJson

interface DownloadData {

    suspend fun getPhoneList(): List<PhoneJson>

    suspend fun getDescription(phoneID: String): PhoneDescriptionJson
}
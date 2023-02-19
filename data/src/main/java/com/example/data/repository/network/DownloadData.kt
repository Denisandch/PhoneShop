package com.example.data.repository.network

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData

interface DownloadData {

    suspend fun downloadPhoneList(): List<PhoneData>

    suspend fun downloadDescription(phoneID: Int): PhoneDescriptionData
}
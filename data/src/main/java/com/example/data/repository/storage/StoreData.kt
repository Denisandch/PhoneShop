package com.example.data.repository.storage

import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.model.PhoneData

interface StoreData {

    suspend fun savePhoneList(list: List<PhoneData>): Boolean

    suspend fun savePhoneDescription(description: PhoneDescriptionData): Boolean

}
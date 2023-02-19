package com.example.data.repository.storage

import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.model.PhoneData


interface GetData {

    suspend fun getPhoneList(): List<PhoneData>

    suspend fun getDescription(phoneID: Int): PhoneDescriptionData

}
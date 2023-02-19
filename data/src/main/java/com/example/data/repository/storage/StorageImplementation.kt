package com.example.data.repository.storage

import android.content.Context
import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.model.PhoneData

class StorageImplementation(context: Context) : Storage {
    override suspend fun getPhoneList(): List<PhoneData> {
        TODO("Not yet implemented")
    }

    override suspend fun getDescription(phoneID: Int): PhoneDescriptionData {
        TODO("Not yet implemented")
    }

    override suspend fun savePhoneList(list: List<PhoneData>): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun savePhoneDescription(description: PhoneDescriptionData): Boolean {
        TODO("Not yet implemented")
    }

}
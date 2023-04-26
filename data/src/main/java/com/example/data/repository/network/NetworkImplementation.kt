package com.example.data.repository.network

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.network.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkImplementation : Network {
    override suspend fun downloadPhoneList(): List<PhoneData> {

        return withContext(Dispatchers.IO) {
            RetrofitInstance.retrofitService.getPhonesList()
        }
    }

    override suspend fun downloadDescription(phoneID: Int): PhoneDescriptionData {

        return withContext(Dispatchers.IO) {
            RetrofitInstance.retrofitService.getDescription(phoneID)
        }

    }
}
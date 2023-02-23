package com.example.data.repository.network

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.network.retrofit.RetrofitInstance


class NetworkImplementation : Network {
    override suspend fun downloadPhoneList(): List<PhoneData> {
        return RetrofitInstance.retrofitService.getPhonesList()
    }

    override suspend fun downloadDescription(phoneID: Int): PhoneDescriptionData {
        return RetrofitInstance.retrofitService.getDescription(phoneID)
    }
}
package com.example.data.repository.network

import com.example.data.repository.model.PhoneJson
import com.example.data.repository.model.PhoneDescriptionJson
import com.example.data.repository.network.retrofit.RetrofitInstance


class DownloadDataImplementation: DownloadData {
    override suspend fun getPhoneList(): List<PhoneJson> {
        return RetrofitInstance.retrofitService.getPhonesList()
    }

    override suspend fun getDescription(phoneID: String): PhoneDescriptionJson {
        return RetrofitInstance.retrofitService.getDescription(phoneID)
    }
}
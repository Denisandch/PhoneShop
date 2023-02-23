package com.example.data.repository.network

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {
    @GET("edf67c189694fdd8067c/phones")
    suspend fun getPhonesList(): List<PhoneData>

    @GET("44e533a62349960a1310/information/{id}")
    suspend fun getDescription(
        @Path("id") checkedPhoneID: Int
    ): PhoneDescriptionData
}
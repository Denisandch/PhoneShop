package com.example.data.repository.network

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {
    @GET("phones")
    suspend fun getPhonesList(): List<PhoneData>

    @GET("information/{id}")
    suspend fun getDescription(
        @Path("id") checkedPhoneID: Int
    ): PhoneDescriptionData
}
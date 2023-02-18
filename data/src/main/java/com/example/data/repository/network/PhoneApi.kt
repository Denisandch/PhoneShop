package com.example.data.repository.network

import com.example.data.repository.model.PhoneJson
import com.example.data.repository.model.PhoneDescriptionJson
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {
    @GET("phones")
    suspend fun getPhonesList(): List<PhoneJson>

    @GET("information/{id}")
    suspend fun getDescription(
        @Path("id") checkedPhoneID: String
    ): PhoneDescriptionJson
}
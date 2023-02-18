package com.example.data.network

import com.example.data.network.model.Phone
import com.example.data.network.model.PhoneDescription
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {
    @GET("phones")
    suspend fun getPhonesList(): List<Phone>

    @GET("information/{id}")
    suspend fun getDescription(
        @Path("id") checkedPhoneID: String
    ): List<PhoneDescription>
}
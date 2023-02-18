package com.example.data.network.retrofit

import com.example.data.network.PhoneApi
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val moshi = Moshi.Builder()
        .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val retrofitService: PhoneApi by lazy {
        retrofit.create(PhoneApi::class.java)
    }
}
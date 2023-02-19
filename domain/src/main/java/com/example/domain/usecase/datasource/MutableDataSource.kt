package com.example.domain.usecase.datasource

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription

interface MutableDataSource : DataSource {

    suspend fun savePhoneList(data: List<Phone>): Boolean

    suspend fun savePhoneDescription(data: PhoneDescription): Boolean

}
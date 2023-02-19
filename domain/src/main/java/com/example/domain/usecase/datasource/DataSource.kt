package com.example.domain.usecase.datasource

import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription

interface DataSource {

   suspend fun getPhoneList(): List<Phone>

   suspend fun getPhoneDescription(phoneID: Int): PhoneDescription

}

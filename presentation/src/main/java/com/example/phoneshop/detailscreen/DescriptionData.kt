package com.example.phoneshop.detailscreen

import com.example.domain.model.PhoneDescription

interface DescriptionData {

    fun getDescription(phoneID: Int)

    fun saveDescription(description: PhoneDescription)
}
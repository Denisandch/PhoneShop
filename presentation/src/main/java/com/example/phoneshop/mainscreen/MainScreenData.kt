package com.example.phoneshop.mainscreen

import com.example.domain.model.Phone

interface MainScreenData {

    fun getPhoneList()

    fun savePhoneList(list: List<Phone>)
}
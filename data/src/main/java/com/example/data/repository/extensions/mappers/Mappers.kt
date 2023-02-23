package com.example.data.repository.extensions.mappers

import com.example.data.repository.model.PhoneData
import com.example.data.repository.model.PhoneDescriptionData
import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription

fun PhoneData.mapDataPhoneToDomain() = Phone(
    id = id,
    name = name,
    price = price,
    picture = picture
)

fun PhoneDescriptionData.mapDataPhoneDescriptionDataToDomain() = PhoneDescription(
    id = id,
    name = name,
    price = price,
    description = description,
    pictures = picture
)

fun Phone.mapDomainPhoneToData() = PhoneData(
    id = id,
    name = name,
    price = price,
    picture = picture
)

fun PhoneDescription.mapDomainPhoneDescriptionDataToData() = PhoneDescriptionData(
    id = id,
    name = name,
    price = price,
    description = description,
    picture = pictures
)

fun List<PhoneData>.mapListDataPhoneToDomain(): List<Phone> {
    val buffer = mutableListOf<Phone>()

    for (phone in this) {
        buffer.add(phone.mapDataPhoneToDomain())
    }

    return buffer
}

fun List<Phone>.mapListPhoneToData(): List<PhoneData> {
    val buffer = mutableListOf<PhoneData>()

    for (phone in this) {
        buffer.add(phone.mapDomainPhoneToData())
    }

    return buffer
}
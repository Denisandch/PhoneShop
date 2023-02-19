package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.repository.Repository

class SaveDescription(
    private val repository: Repository
) : SaveData<PhoneDescription> {

    override suspend fun saveData(data: PhoneDescription): Boolean {
        return repository.savePhoneDescription(data)
    }

}
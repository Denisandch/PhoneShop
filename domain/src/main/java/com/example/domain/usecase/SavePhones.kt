package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.repository.Repository

class SavePhones(
    private val repository: Repository
) : SaveData<List<Phone>> {

    override suspend fun saveData(data: List<Phone>): Boolean {
        return repository.savePhoneList(data)
    }

}
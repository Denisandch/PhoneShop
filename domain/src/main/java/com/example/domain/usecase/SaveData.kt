package com.example.domain.usecase

interface SaveData<T> {

    suspend fun saveData(data: T): Boolean

}

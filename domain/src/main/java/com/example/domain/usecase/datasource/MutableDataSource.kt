package com.example.domain.usecase.datasource

interface MutableDataSource<T> : DataSource<T> {
    suspend fun saveData(data: T)

}
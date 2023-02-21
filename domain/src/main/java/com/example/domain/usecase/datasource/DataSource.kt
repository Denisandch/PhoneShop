package com.example.domain.usecase.datasource

interface DataSource<T> {
    suspend fun getData(id: Int = -1): T?

}
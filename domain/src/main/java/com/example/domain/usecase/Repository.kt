package com.example.domain.usecase

import com.example.domain.usecase.datasource.DataSource
import com.example.domain.usecase.datasource.MutableDataSource

open class Repository<T>(
    private val cachedDataSource: MutableDataSource<T>,
    private val cloudDataSource: DataSource<T>
) : MutableDataSource<T> {

    override suspend fun saveData(data: T) {
        cachedDataSource.saveData(data)
    }

    override suspend fun getData(id: Int): T {
        var result = cachedDataSource.getData(id)
        if (result == null) {
            result = cloudDataSource.getData(id)!!
            //cachedDataSource.saveData(result!!)
        }

        return result
    }
}
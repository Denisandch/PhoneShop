package com.example.domain.usecase

import com.example.domain.model.Phone
import com.example.domain.usecase.datasource.DataSource
import com.example.domain.usecase.datasource.MutableDataSource

class PhoneListRepository(
    private val cachedDataSource: PhoneListCachedDataSource,
    private val cloudDataSource: PhoneListCloudDataSource
) : Repository<List<Phone>>(
    cachedDataSource,
    cloudDataSource
)
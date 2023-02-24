package com.example.domain.usecase

import com.example.domain.model.Phone


class PhoneListRepository(
    private val cachedDataSource: PhoneListCachedDataSource,
    private val cloudDataSource: PhoneListCloudDataSource
) : Repository<List<Phone>>(
    cachedDataSource,
    cloudDataSource
)
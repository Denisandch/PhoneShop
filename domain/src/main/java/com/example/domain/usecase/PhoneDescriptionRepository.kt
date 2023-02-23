package com.example.domain.usecase

import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.datasource.DataSource
import com.example.domain.usecase.datasource.MutableDataSource

class PhoneDescriptionRepository(
    private val cachedDataSource: PhoneDescriptionCachedDataSource,
    private val cloudDataSource: PhoneDescriptionCloudDataSource
) : Repository<PhoneDescription>(
    cachedDataSource,
    cloudDataSource
)
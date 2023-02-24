package com.example.domain.usecase

import com.example.domain.model.PhoneDescription


class PhoneDescriptionRepository(
    private val cachedDataSource: PhoneDescriptionCachedDataSource,
    private val cloudDataSource: PhoneDescriptionCloudDataSource
) : Repository<PhoneDescription>(
    cachedDataSource,
    cloudDataSource
)
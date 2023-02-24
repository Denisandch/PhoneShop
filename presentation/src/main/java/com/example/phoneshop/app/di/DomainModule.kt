package com.example.phoneshop.app.di

import com.example.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    single<PhoneDescriptionCachedDataSource> {
        PhoneDescriptionCachedDataSource(repositoryToData = get())
    }

    single<PhoneDescriptionCloudDataSource> {
        PhoneDescriptionCloudDataSource(repositoryToData = get())
    }

    single<PhoneListCachedDataSource> {
        PhoneListCachedDataSource(repositoryToData = get())
    }

    single<PhoneListCloudDataSource> {
        PhoneListCloudDataSource(repositoryToData = get())
    }

    single<PhoneDescriptionRepository> {
        PhoneDescriptionRepository(
            cachedDataSource = get(),
            cloudDataSource = get()
        )
    }

    single<PhoneListRepository> {
        PhoneListRepository(
            cachedDataSource = get(),
            cloudDataSource = get()
        )
    }
}
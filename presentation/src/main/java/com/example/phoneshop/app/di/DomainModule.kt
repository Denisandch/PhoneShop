package com.example.phoneshop.app.di

import android.util.Log
import com.example.domain.model.Phone
import com.example.domain.model.PhoneDescription
import com.example.domain.usecase.*
import com.example.domain.usecase.datasource.DataSource
import com.example.domain.usecase.datasource.MutableDataSource
import org.koin.dsl.module

val domainModule = module {

    single<PhoneDescriptionCachedDataSource> {
        Log.i("TAG", "Создание PhoneDescriptionCachedDataSource")
        PhoneDescriptionCachedDataSource(repositoryToData = get())
    }

    single<PhoneDescriptionCloudDataSource> {
        Log.i("TAG", "Создание PhoneDescriptionCloudDataSource")
        PhoneDescriptionCloudDataSource(repositoryToData = get())
    }

    single<PhoneListCachedDataSource> {
        Log.i("TAG", "Создание PhoneListCachedDataSource")
        PhoneListCachedDataSource(repositoryToData = get())
    }

    single<PhoneListCloudDataSource> {
        Log.i("TAG", "Создание PhoneListCloudDataSource")
        PhoneListCloudDataSource(repositoryToData = get())
    }

    single<PhoneDescriptionRepository> {
        Log.i("TAG", "Создание com.example.domain.usecase.Repository<PhoneDescription")
        PhoneDescriptionRepository(
            cachedDataSource = get(),
            cloudDataSource = get()
        )
    }

    single<PhoneListRepository> {
        Log.i("TAG", "Создание com.example.domain.usecase.Repository<List<Phone>>")
        PhoneListRepository(
            cachedDataSource = get(),
            cloudDataSource = get()
        )
    }
}
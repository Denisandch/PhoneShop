package com.example.phoneshop.app.di

import android.util.Log
import com.example.data.repository.RepositoryToDataImplementation
import com.example.data.repository.network.Network
import com.example.data.repository.network.NetworkImplementation
import com.example.data.repository.storage.Storage
import com.example.data.repository.storage.StorageImplementation
import com.example.domain.repository.RepositoryToData
import org.koin.dsl.module

val dataModule = module {

    single<Network> {
        Log.i("TAG", "Создание НЕТВОРКА")
        NetworkImplementation()
    }

    single<Storage> {
        Log.i("TAG", "Создание СТОРАГЕ")
        StorageImplementation(context = get())
    }

    factory<RepositoryToData> {
        Log.i("TAG", "Создание РЕПОЗИТОРИЯ ДАТА")
        RepositoryToDataImplementation(
            network = get(),
            storage = get()
        )
    }
}

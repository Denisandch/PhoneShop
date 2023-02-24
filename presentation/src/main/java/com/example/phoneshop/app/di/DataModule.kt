package com.example.phoneshop.app.di

import com.example.data.repository.RepositoryToDataImplementation
import com.example.data.repository.network.Network
import com.example.data.repository.network.NetworkImplementation
import com.example.data.repository.storage.Storage
import com.example.data.repository.storage.StorageImplementation
import com.example.domain.repository.RepositoryToData
import org.koin.dsl.module

val dataModule = module {

    single<Network> {
        NetworkImplementation()
    }

    single<Storage> {
        StorageImplementation(context = get())
    }

    factory<RepositoryToData> {
        RepositoryToDataImplementation(
            network = get(),
            storage = get()
        )
    }
}

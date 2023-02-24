package com.example.phoneshop.app.di

import com.example.phoneshop.ApplicationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<ApplicationViewModel> {
        ApplicationViewModel(
            phoneListRepository = get(),
            descriptionRepository = get()
        )
    }

}
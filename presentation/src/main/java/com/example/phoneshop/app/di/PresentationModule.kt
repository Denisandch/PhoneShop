package com.example.phoneshop.app.di

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.phoneshop.ApplicationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<ApplicationViewModel> {
        Log.i("TAG", "ВЬЮМОДЕЛЬ")
        ApplicationViewModel(
            phoneListRepository = get(),
            descriptionRepository = get()
        )
    }

}
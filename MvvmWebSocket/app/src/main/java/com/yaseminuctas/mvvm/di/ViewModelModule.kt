package com.yaseminuctas.mvvm.di

import com.yaseminuctas.mvvm.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel()
    }

}
package com.yaseminuctas.mvvm.di

import com.yaseminuctas.mvvm.data.network.Api
import org.koin.dsl.module
import retrofit2.Retrofit


val apiModule = module {

    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
    single { provideApi(get()) }

}
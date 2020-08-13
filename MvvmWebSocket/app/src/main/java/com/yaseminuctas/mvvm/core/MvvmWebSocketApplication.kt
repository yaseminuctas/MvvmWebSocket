package com.yaseminuctas.mvvm.core

import android.app.Application
import com.yaseminuctas.mvvm.di.apiModule
import com.yaseminuctas.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MvvmWebSocketApplication: Application() {


        override fun onCreate() {
            super.onCreate()

            startKoin{
                androidLogger()
                androidContext(this@MvvmWebSocketApplication)
                modules(
                    apiModule,
                    viewModelModule)
            }
        }
    }

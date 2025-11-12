package com.vivek.demo

import android.app.Application
import com.vivek.demo.di.koinModule
import com.vivek.demo.di.koinViewModelModule
import com.vivek.demo.di.sharedViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                koinModule, koinViewModelModule,
                sharedViewModelModule()
            )

        }
    }
}
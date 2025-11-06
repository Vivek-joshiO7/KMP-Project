package com.vivek.demo

import android.app.Application
import com.vivek.demo.di.initKoin
import com.vivek.demo.di.koinModule
import com.vivek.demo.di.sharedViewModelModule
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BaseApplication)
            modules(
                koinModule,
                sharedViewModelModule()
            )

        }
    }
}
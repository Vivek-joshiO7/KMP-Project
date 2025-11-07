package com.vivek.demo.di

import org.koin.core.context.startKoin

fun initKoinWeb() {
    startKoin {
        modules(koinModule, sharedViewModelModule())
    }
}
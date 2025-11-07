package com.vivek.demo.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin{
        modules(koinModule,sharedViewModelModule())
    }
}
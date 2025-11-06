package com.vivek.demo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration : KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(koinModule,
        sharedViewModelModule()
    )
}

// For non-Android platforms (iOS, Desktop, Web)
fun initKoin() = initKoin {}
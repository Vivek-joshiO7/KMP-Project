package com.vivek.demo.di


import com.vivek.demo.ui.MainViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


actual fun sharedViewModelModule(): Module = module {
//    singleOf(::MainViewModel)
    single { MainViewModel(get()) }
}
package com.vivek.demo.di


import com.vivek.demo.ui.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module


actual fun sharedViewModelModule(): Module = module {
    single { MainViewModel(get()) }
}
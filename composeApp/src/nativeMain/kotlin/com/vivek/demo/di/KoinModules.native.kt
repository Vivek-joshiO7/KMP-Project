package com.vivek.demo.di

import com.vivek.demo.ui.MainViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val mainViewModelModule = module {
    single { MainViewModel(get()) }
}

actual fun sharedViewModelModule(): Module = mainViewModelModule

object ProvideMainViewModel : KoinComponent {
    fun getMainViewModel(): MainViewModel = get()
}

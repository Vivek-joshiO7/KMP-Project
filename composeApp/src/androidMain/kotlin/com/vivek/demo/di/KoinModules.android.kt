package com.vivek.demo.di


import com.vivek.demo.ui.MainViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


private val mainViewModelModule = module {

    viewModel { MainViewModel(get()) }

}
actual fun sharedViewModelModule(): Module  = mainViewModelModule
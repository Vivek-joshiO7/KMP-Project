package com.vivek.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vivek.demo.di.koinModule
import com.vivek.demo.di.koinViewModelModule
import com.vivek.demo.di.sharedViewModelModule
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(koinModule, koinViewModelModule, sharedViewModelModule())
    }
    Window(
        onCloseRequest = ::exitApplication,
        alwaysOnTop = true,
        title = "KMP-Project",
    ) {
        App()
    }
}
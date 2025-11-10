package com.vivek.demo

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.vivek.demo.di.koinModule
import com.vivek.demo.di.sharedViewModelModule
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(koinModule, sharedViewModelModule())
    }
    ComposeViewport {
        App()
    }
}
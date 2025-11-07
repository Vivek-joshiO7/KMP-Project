package com.vivek.demo

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.vivek.demo.di.initKoinWeb

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoinWeb()
    ComposeViewport {
        App()
    }
}
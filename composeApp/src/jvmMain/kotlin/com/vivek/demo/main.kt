package com.vivek.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vivek.demo.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP-Project",
    ) {
        App()
    }
}
package com.vivek.demo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.vivek.demo.ui.screens.news_screen.NewsScreen
import com.vivek.demo.ui.screens.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            SplashScreen()
        }
    }
}
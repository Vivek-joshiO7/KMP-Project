package com.vivek.demo.ui.screens.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.img_splash
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.img_splash),
            contentDescription = "Splash Image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen()
}
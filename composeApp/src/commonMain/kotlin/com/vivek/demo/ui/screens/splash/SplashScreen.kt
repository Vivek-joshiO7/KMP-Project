package com.vivek.demo.ui.screens.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.ic_main
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(onSplashComplete : () -> Unit) {
    LaunchedEffect(Unit){
        delay(3000)
        // Navigate to the next screen or perform any action after the splash screen
        onSplashComplete.invoke()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.ic_main),
            contentDescription = "Splash Image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen({})
}
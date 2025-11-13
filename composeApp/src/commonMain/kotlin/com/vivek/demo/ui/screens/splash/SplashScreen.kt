package com.vivek.demo.ui.screens.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.vivek.demo.domain.usecase.local_store_settings.UserEntryUseCases
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.ic_main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun SplashScreen(onSplashComplete: (Boolean) -> Unit) {
    val userEntryUseCases = koinInject<UserEntryUseCases>()
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        delay(3000)

        scope.launch {
            onSplashComplete.invoke(userEntryUseCases.getUserEntry.invoke())
        }
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
    SplashScreen {}
}
package com.vivek.demo.ui.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object SplashScreen : Routes()

    @Serializable
    data object OnboardingScreen : Routes()
    @Serializable
    data object HomeScreen : Routes()
}
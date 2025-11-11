package com.vivek.demo.ui.screens.onboarding

import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.img_onboarding_one
import kmp_project.composeapp.generated.resources.img_onboarding_three
import kmp_project.composeapp.generated.resources.img_onboarding_two
import org.jetbrains.compose.resources.DrawableResource

data class Page(
    val imageRes: DrawableResource,
    val title: String,
    val description: String
)

val pages = listOf(
    Page(
        imageRes = Res.drawable.img_onboarding_one,
        title = "Welcome to News App",
        description = "Discover new features and functionalities with our app."
    ),
    Page(
        imageRes = Res.drawable.img_onboarding_two,
        title = "Stay Updated",
        description = "Connect with people and share your experiences seamlessly."
    ),
    Page(
        imageRes = Res.drawable.img_onboarding_three,
        title = "Get Started",
        description = "Let's get you set up and ready to explore the app!"
    )
)

package com.vivek.demo.ui.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivek.demo.ui.navigation.routes.Routes
import com.vivek.demo.ui.screens.home.HomeScreen
import com.vivek.demo.ui.screens.home.HomeViewModel
import com.vivek.demo.ui.screens.news_screen.NewsScreen
import com.vivek.demo.ui.screens.onboarding.OnboardingScreen
import com.vivek.demo.ui.screens.onboarding.OnboardingViewModel
import com.vivek.demo.ui.screens.splash.SplashScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen
    ) {
        // Splash Screen
        composable<Routes.SplashScreen> {
            SplashScreen(
                onSplashComplete = { isUserEntered ->
                    navController.navigate(if (isUserEntered) Routes.HomeScreen else Routes.OnboardingScreen)
                }
            )
        }

        composable<Routes.OnboardingScreen> {
            OnboardingScreen(
                navController = navController,
                viewModel = koinViewModel<OnboardingViewModel>()
            )
        }

        composable<Routes.HomeScreen>{
            HomeScreen(navController = navController,
                homeViewModel = koinViewModel<HomeViewModel>())
        }

        composable<Routes.NewsScreen> {
            NewsScreen()
        }
    }
}
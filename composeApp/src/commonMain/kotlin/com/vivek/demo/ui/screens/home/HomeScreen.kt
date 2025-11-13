package com.vivek.demo.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    Column(modifier = Modifier) {
        Practice()
    }
}

@Composable
fun Practice() {
    Column {
        BasicText("Hello Home Screen", modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    //This is Preview of the screen
    HomeScreen(navController = rememberNavController(), homeViewModel = koinViewModel())
}
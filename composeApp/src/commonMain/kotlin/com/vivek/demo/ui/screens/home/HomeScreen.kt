package com.vivek.demo.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vivek.demo.ui.theme.Blue
import com.vivek.demo.ui.theme.BlueGray
import com.vivek.demo.ui.theme.BlueLite70
import com.vivek.demo.ui.theme.Gray
import com.vivek.demo.ui.theme.White
import kmp_project.composeapp.generated.resources.Res
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AnnotatedStringFunctionExample()
    }
}

@Composable
fun AnnotatedStringFunctionExample() {
    val annotatedString = buildAnnotatedString {
        blueGradientText("Introducing")
        append("\n")
        blueWhiteGradientText("Kotlin Multiplatform")
        append("\n")
        blueGradientText("To World")
    }
    BasicText(annotatedString)
}

private fun AnnotatedString.Builder.blueGradientText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(listOf(Blue,BlueGray)),
            fontSize = 42.sp,
            fontWeight = FontWeight.Medium
        )
    ) {
        append(text)
    }
}

private fun AnnotatedString.Builder.blueWhiteGradientText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(listOf(Blue,White,BlueLite70)),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
    ) {
        append(text)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    //This is Preview of the screen
    HomeScreen(navController = rememberNavController(), homeViewModel = koinViewModel())
}
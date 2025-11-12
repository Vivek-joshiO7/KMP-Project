package com.vivek.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vivek.demo.ui.navigation.nav_graph.AppNavGraph
import com.vivek.demo.ui.theme.DarkColors
import com.vivek.demo.ui.theme.LightColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors) {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            AppNavGraph()
        }
    }

}
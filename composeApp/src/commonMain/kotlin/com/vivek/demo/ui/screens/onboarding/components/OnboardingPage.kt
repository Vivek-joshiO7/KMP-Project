package com.vivek.demo.ui.screens.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.vivek.demo.ui.Dimens.Medium_Padding_1
import com.vivek.demo.ui.screens.onboarding.Page
import com.vivek.demo.ui.screens.onboarding.pages
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
            painter = painterResource(page.imageRes),
            contentDescription = "Onboarding Image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Medium_Padding_1))
        Text(
            page.title,
            modifier = Modifier.padding(horizontal = Medium_Padding_1),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
        Text(
            page.description,
            modifier = Modifier.padding(horizontal = Medium_Padding_1),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPagePreview() {
    OnboardingPage(page = pages[0])
}
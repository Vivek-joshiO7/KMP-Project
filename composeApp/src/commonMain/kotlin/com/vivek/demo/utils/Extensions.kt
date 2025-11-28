package com.vivek.demo.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.vivek.demo.ui.theme.Blue
import com.vivek.demo.ui.theme.BlueGray
import com.vivek.demo.ui.theme.BlueLite70
import com.vivek.demo.ui.theme.White

fun AnnotatedString.Builder.blueGradientText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(listOf(Blue, BlueGray)),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
        )

    ) {
        append(text)
    }
}

fun AnnotatedString.Builder.blueWhiteGradientText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(listOf(Blue, White, BlueLite70)),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    ) {
        append(text)
    }
}

fun AnnotatedString.Builder.plainColorText(text: String, color: Color) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(listOf(color,color)),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
    ) {
        append(text)
    }
}

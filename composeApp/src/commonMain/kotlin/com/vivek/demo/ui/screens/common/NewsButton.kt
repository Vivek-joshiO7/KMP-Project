package com.vivek.demo.ui.screens.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vivek.demo.ui.theme.Gray
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold))
    }
}

@Preview(showBackground = true)
@Composable
fun NewsButtonPreview() {
    NewsButton(text = "Click Me", onClick = {})
}

@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsTextButtonPreview() {
    NewsTextButton(text = "Click Me", onClick = {})
}

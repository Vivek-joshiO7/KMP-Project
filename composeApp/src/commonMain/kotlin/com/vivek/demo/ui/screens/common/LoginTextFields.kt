package com.vivek.demo.ui.screens.common

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginTextField(text: String, onValueChange: (String) -> Unit,modifier: Modifier,trailingIcon : @Composable (() -> Unit)? = null) {

    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange.invoke(it) },
        modifier = modifier,
        trailingIcon  = trailingIcon
    )
}

@Preview
@Composable
fun LoginTextFieldPreview() {
    LoginTextField("", {}, Modifier)
}



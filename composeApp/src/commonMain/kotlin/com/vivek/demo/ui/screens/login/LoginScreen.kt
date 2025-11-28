package com.vivek.demo.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.demo.ui.screens.common.LoginTextField
import com.vivek.demo.ui.theme.Black
import com.vivek.demo.ui.theme.BlueLite
import com.vivek.demo.ui.theme.White
import com.vivek.demo.utils.plainColorText
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.welcome_back
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    val annotatedString = buildAnnotatedString {
        plainColorText("Hello", Black)
        append("\n\n")
        plainColorText("Again!", BlueLite)
    }
    var text by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.background(White).padding(horizontal = 20.dp)) {
        TopSection(annotatedString)

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it},
            modifier = Modifier
        )
    }

}

@Composable
fun TopSection(annotatedString: AnnotatedString) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(annotatedString)
        Spacer(Modifier.height(20.dp))
        Text(text = stringResource(Res.string.welcome_back), modifier = Modifier, fontSize = 22.sp)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
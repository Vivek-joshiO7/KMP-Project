package com.vivek.demo.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.demo.ui.screens.common.LoginTextField
import com.vivek.demo.ui.theme.Black
import com.vivek.demo.ui.theme.BlueLite
import com.vivek.demo.ui.theme.TextGray
import com.vivek.demo.ui.theme.White
import com.vivek.demo.utils.plainColorText
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.ic_main
import kmp_project.composeapp.generated.resources.ic_splash
import kmp_project.composeapp.generated.resources.welcome_back
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    val annotatedString = buildAnnotatedString {
        plainColorText("Hello", Black,48)
        append("\n\n")
        plainColorText("Again!", BlueLite,48)
    }
    val userName = buildAnnotatedString {
        plainColorText("username",TextGray,12)
        plainColorText("*",Color.Red,12)
    }
    val password = buildAnnotatedString {
        plainColorText("password",TextGray,12)
        plainColorText("*",Color.Red,12)
    }
    var text by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        TopSection(annotatedString)

        Spacer(Modifier.height(20.dp))

        Text(userName)
        OutlinedTextField(
            value = text,
            onValueChange = { text = it},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Text(password)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it},
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    painter = if (isPasswordVisible) painterResource(Res.drawable.ic_main) else painterResource(Res.drawable.ic_splash),
                    contentDescription = "Password Security",
                    modifier = Modifier.clickable{
                        isPasswordVisible != isPasswordVisible
                    }
                )
            },
            visualTransformation = if (isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None
        )
    }

}

@Composable
fun TopSection(annotatedString: AnnotatedString) {
    Column(modifier = Modifier) {
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
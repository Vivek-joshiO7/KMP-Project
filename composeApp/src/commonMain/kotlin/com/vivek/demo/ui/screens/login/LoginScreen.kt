package com.vivek.demo.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.demo.ui.screens.common.LabeledCheckbox
import com.vivek.demo.ui.theme.Black
import com.vivek.demo.ui.theme.BlueLite
import com.vivek.demo.ui.theme.BlueLite2
import com.vivek.demo.ui.theme.Gray
import com.vivek.demo.ui.theme.Gray2
import com.vivek.demo.ui.theme.TextGray
import com.vivek.demo.ui.theme.White
import com.vivek.demo.utils.plainColorText
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.facebook
import kmp_project.composeapp.generated.resources.forgot_password
import kmp_project.composeapp.generated.resources.ic_eye
import kmp_project.composeapp.generated.resources.ic_hide_eye
import kmp_project.composeapp.generated.resources.login
import kmp_project.composeapp.generated.resources.or_continue_with
import kmp_project.composeapp.generated.resources.welcome_back
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    val textColor = if (isSystemInDarkTheme()) White else Black
    val annotatedString = buildAnnotatedString {
        plainColorText("Hello", textColor, 48)
        append("\n\n")
        plainColorText("Again!", BlueLite, 48)
    }
    val userNameText = buildAnnotatedString {
        plainColorText("Username", textColor, 14)
        plainColorText("*", Color.Red, 14)
    }
    val passwordText = buildAnnotatedString {
        plainColorText("Password", textColor, 14)
        plainColorText("*", Color.Red, 14)
    }
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    var isChecked by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(horizontal = 20.dp).fillMaxSize()) {

        Text(annotatedString)

        Spacer(Modifier.height(20.dp))

        Text(text = stringResource(Res.string.welcome_back), modifier = Modifier, fontSize = 22.sp, color = textColor)

        Spacer(Modifier.height(20.dp))

        Text(userNameText, modifier = Modifier)

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
            colors = OutlinedTextFieldDefaults.colors(textColor)
        )

        Spacer(Modifier.height(20.dp))

        Text(passwordText,modifier = Modifier)

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
            colors = OutlinedTextFieldDefaults.colors(textColor),
            trailingIcon = {
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }){
                    Icon(if (isPasswordVisible) painterResource(Res.drawable.ic_eye) else painterResource(Res.drawable.ic_hide_eye), contentDescription = "Password Toggle")
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(Modifier.height(10.dp))

        Row(Modifier.fillMaxWidth().wrapContentHeight(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            LabeledCheckbox(checked = isChecked,onCheckedChange = {isChecked = it}, modifier = Modifier.wrapContentSize(), text ="Remember me", textColor = White)

            Text(text = stringResource(Res.string.forgot_password),modifier = Modifier.wrapContentSize(), color = BlueLite2)
        }

        Spacer(Modifier.height(16.dp))


        Button(onClick = {}, modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally), shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(BlueLite), content = {
            Text(stringResource(Res.string.login), color = White, fontSize = 14.sp)
        })

        Spacer(Modifier.height(10.dp))

        Text(stringResource(Res.string.or_continue_with), modifier = Modifier.align(Alignment.CenterHorizontally), color = textColor)

        Row(modifier = Modifier) {


        }

    }

}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
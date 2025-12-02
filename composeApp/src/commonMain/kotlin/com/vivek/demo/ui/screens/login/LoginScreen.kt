package com.vivek.demo.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dokar.sonner.ToastType
import com.dokar.sonner.Toaster
import com.dokar.sonner.rememberToasterState
import com.vivek.demo.ui.screens.common.LabeledCheckbox
import com.vivek.demo.ui.screens.common.SocialLogin
import com.vivek.demo.ui.theme.Black
import com.vivek.demo.ui.theme.BlueLite
import com.vivek.demo.ui.theme.BlueLite2
import com.vivek.demo.ui.theme.White
import com.vivek.demo.utils.plainColorText
import kmp_project.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    val textColor = if (isSystemInDarkTheme()) White else Black

    ConstraintLayout(Modifier.fillMaxSize().padding(20.dp).verticalScroll(rememberScrollState())) {
        val (topSec,middleSec,bottomSec,orContinue)  = createRefs()


        TopSection(modifier = Modifier.fillMaxWidth().constrainAs(topSec){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }, textColor = textColor)

        MiddleSection(modifier = Modifier.fillMaxWidth().constrainAs(middleSec){
            top.linkTo(topSec.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(orContinue.top)
        }.padding(vertical = 10.dp), textColor = textColor)


        Text(
            stringResource(Res.string.or_continue_with),
            modifier = Modifier.constrainAs(orContinue){
                top.linkTo(middleSec.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(bottomSec.top)
            }.padding(vertical = 10.dp),
            color = textColor
        )

        BottonSection(modifier = Modifier.fillMaxWidth().constrainAs(bottomSec){
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }, textColor = textColor)
    }

}

@Composable
fun BottonSection(modifier: Modifier, textColor: Color) {

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SocialLogin(
                modifier = Modifier.weight(1f),
                drawable = Res.drawable.ic_facebook,
                contentDescription = "Facebook Login",
                text = Res.string.facebook
            )

            Spacer(Modifier.width(30.dp))

            SocialLogin(
                modifier = Modifier.weight(1f),
                drawable = Res.drawable.ic_google,
                contentDescription = "Google Login",
                text = Res.string.google
            )
        }

        Spacer(Modifier.height(20.dp))

        SignUpRow(
            onSignUpClick = {},
            textColor = textColor,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun MiddleSection(modifier: Modifier, textColor: Color) {
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
    val userNameText = buildAnnotatedString {
        plainColorText("Username", textColor, 14)
        plainColorText("*", Color.Red, 14)
    }
    val passwordText = buildAnnotatedString {
        plainColorText("Password", textColor, 14)
        plainColorText("*", Color.Red, 14)
    }

    val toaster = rememberToasterState()
    Column(modifier = modifier) {
        Toaster(state = toaster)

        Text(userNameText, modifier = Modifier)

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
            colors = OutlinedTextFieldDefaults.colors(textColor)
        )

        Spacer(Modifier.height(20.dp))

        Text(passwordText, modifier = Modifier)

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
            colors = OutlinedTextFieldDefaults.colors(textColor),
            trailingIcon = {
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Icon(
                        if (isPasswordVisible) painterResource(Res.drawable.ic_eye) else painterResource(Res.drawable.ic_hide_eye),
                        contentDescription = "Password Toggle"
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier.fillMaxWidth().wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LabeledCheckbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                modifier = Modifier.wrapContentSize(),
                text = "Remember me",
                textColor = textColor
            )

            Text(
                text = stringResource(Res.string.forgot_password),
                modifier = Modifier.wrapContentSize(),
                color = BlueLite2
            )
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                toaster.show(
                    message = "Hello Toaster",
                    type = ToastType.Success,
                )
            },
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(BlueLite),
            content = {
                Text(stringResource(Res.string.login), color = White, fontSize = 14.sp)
            })

    }
}

@Composable
fun TopSection(modifier: Modifier, textColor: Color) {
    val annotatedString = buildAnnotatedString {
        plainColorText("Hello", textColor, 48)
        append("\n\n")
        plainColorText("Again!", BlueLite, 48)
    }
    Column(modifier = modifier) {

        Text(annotatedString)

        Spacer(Modifier.height(20.dp))

        Text(text = stringResource(Res.string.welcome_back), modifier = Modifier, fontSize = 22.sp, color = textColor)

    }
}


@Composable
fun SignUpRow(
    onSignUpClick: () -> Unit,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        BasicText(
            text = stringResource(Res.string.do_not_have_account),
            style = TextStyle(
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.width(4.dp))

        BasicText(
            text = stringResource(Res.string.sign_up),
            modifier = Modifier.clickable { onSignUpClick() },
            style = TextStyle(
                brush = Brush.linearGradient(listOf(BlueLite2, BlueLite2)),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
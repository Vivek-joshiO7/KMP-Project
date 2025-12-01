package com.vivek.demo.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.vivek.demo.ui.theme.Gray2
import com.vivek.demo.ui.theme.TextGray
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.facebook
import kmp_project.composeapp.generated.resources.ic_eye
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SocialLogin(
    drawable : DrawableResource,
    contentDescription : String,
    text : StringResource
){
    Row(modifier = Modifier.clip(RoundedCornerShape(6.dp)).background(Gray2).padding(5.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
        Image(painter = painterResource(drawable), contentDescription = contentDescription)
        Text(stringResource(text), modifier = Modifier.padding(start = 10.dp), color = TextGray, fontWeight = Bold)
    }
}

@Preview
@Composable
fun SocialLoginPreview(){
    SocialLogin(drawable = Res.drawable.ic_eye, contentDescription = "Facebook Login", text = Res.string.facebook)
}

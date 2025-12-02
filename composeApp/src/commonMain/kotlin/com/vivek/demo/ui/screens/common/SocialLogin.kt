package com.vivek.demo.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.demo.ui.theme.Gray2
import com.vivek.demo.ui.theme.TextGray
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.facebook
import kmp_project.composeapp.generated.resources.ic_eye
import kmp_project.composeapp.generated.resources.ic_facebook
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SocialLogin(
    modifier : Modifier = Modifier,
    drawable : DrawableResource,
    contentDescription : String,
    text : StringResource
){
    Box(modifier = modifier.clip(RoundedCornerShape(8.dp)).background(Gray2).padding(10.dp), contentAlignment = Alignment.Center){
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
            Image(painter = painterResource(drawable), contentDescription = contentDescription)
            Text(stringResource(text), modifier = Modifier.padding(start = 10.dp), color = TextGray, fontWeight = Bold, fontSize = 16.sp)
        }
    }
}

@Preview
@Composable
fun SocialLoginPreview(){
    SocialLogin(drawable = Res.drawable.ic_facebook, contentDescription = "Facebook Login", text = Res.string.facebook)
}

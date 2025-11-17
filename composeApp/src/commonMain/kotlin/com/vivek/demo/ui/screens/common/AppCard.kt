package com.vivek.demo.ui.screens.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.demo.ui.theme.Black
import com.vivek.demo.ui.theme.White
import kmp_project.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

data class Publisher(
    val name: StringResource, val profileImage: DrawableResource, val profileName: StringResource
)

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: StringResource,
    desc: StringResource,
    publisher: Publisher
) {
    var descState by remember { mutableStateOf(false) }
    Card(
        modifier = modifier.animateContentSize(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Black.copy(.7f))
    ) {

        Column {

            Image(
                painter = painterResource(image),
                contentDescription = "CardImage",
                modifier = Modifier.fillMaxWidth().fillMaxHeight(.3f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)) {
                Text(
                    text = stringResource(title),
                    modifier = Modifier.fillMaxWidth(),
                    color = White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
                Text(
                    text = stringResource(desc),
                    modifier = Modifier.fillMaxWidth().clickable {
                        descState = !descState
                    },
                    color = White.copy(.7f),
                    fontSize = 14.sp,
                    maxLines = if (descState) 100 else 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(publisher.profileImage),
                        contentDescription = "Publisher image",
                        modifier = Modifier.clip(CircleShape).size(32.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    val annotatedString = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = White,
                                fontSize = 16.sp
                            )
                        ) {
                            append(stringResource(publisher.name))
                        }
                        append("\n")
                        withStyle(
                            style = SpanStyle(
                                fontSize = 14.sp,
                                color = White.copy(.7f),
                            )
                        ) {
                            append(stringResource(publisher.profileName))
                        }
                    }
                    Text(text = annotatedString)
                }
            }

        }
    }

}

@Preview
@Composable
fun AppCardPreview() {
    AppCard(
        modifier = Modifier,
        image = Res.drawable.img_onboarding_one,
        title = Res.string.app_name,
        desc = Res.string.dummy_desc,
        publisher = Publisher(
            name = Res.string.developer_name,
            profileImage = Res.drawable.img_onboarding_two,
            profileName = Res.string.profile_name
        )
    )
}
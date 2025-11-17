package com.vivek.demo.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vivek.demo.ui.Dimens
import com.vivek.demo.ui.screens.common.AppCard
import com.vivek.demo.ui.screens.common.Publisher
import com.vivek.demo.utils.blueGradientText
import com.vivek.demo.utils.blueWhiteGradientText
import kmp_project.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

data class CardItems(
    val image : DrawableResource,
    val title : StringResource,
    val desc : StringResource,
    val publisher: Publisher
)
@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    val itemList = homeViewModel.getItems.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = Dimens.MediumPadding1),
        contentAlignment = Alignment.Center
    ) {
        Column {
            AnnotatedStringFunctionExample(modifier = Modifier)

            LazyColumn(modifier = Modifier.padding(20.dp)) {
                items(itemList.value.size){it ->
                    AppCard(
                        modifier = Modifier.wrapContentSize(),
                        image = itemList.value[it].image,
                        title = itemList.value[it].title,
                        desc = itemList.value[it].desc,
                        publisher = Publisher(
                            name = itemList.value[it].publisher.name,
                            profileImage = itemList.value[it].publisher.profileImage,
                            profileName = itemList.value[it].publisher.profileName
                        )
                    )
                    Spacer(Modifier.height(20.dp))
                }
            }
        }

    }
}

@Composable
fun AnnotatedStringFunctionExample(modifier : Modifier) {
    val annotatedString = buildAnnotatedString {
        blueGradientText("Introducing")
        append("\n")
        blueWhiteGradientText("Kotlin Multiplatform")
    }
    BasicText(annotatedString, modifier =  modifier)
}

@Preview
@Composable
fun HomeScreenPreview() {
    //This is Preview of the screen
    HomeScreen(navController = rememberNavController(), homeViewModel = koinViewModel())
}
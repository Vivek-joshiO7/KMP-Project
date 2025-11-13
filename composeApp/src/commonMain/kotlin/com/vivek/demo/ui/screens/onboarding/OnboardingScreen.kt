package com.vivek.demo.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import com.russhwolf.settings.Settings
import com.vivek.demo.domain.usecase.local_store_settings.UserEntryUseCases
import com.vivek.demo.ui.Dimens.Medium_Padding_2
import com.vivek.demo.ui.Dimens.Page_Indicator_Width
import com.vivek.demo.ui.Dimens.Small_Padding_1
import com.vivek.demo.ui.navigation.routes.Routes
import com.vivek.demo.ui.screens.common.NewsButton
import com.vivek.demo.ui.screens.common.NewsTextButton
import com.vivek.demo.ui.screens.onboarding.components.OnboardingPage
import com.vivek.demo.ui.screens.onboarding.components.PageIndicator
import com.vivek.demo.utils.Constants
import kotlinx.coroutines.launch
import net.codinux.log.LogEvent
import net.codinux.log.LogLevel
import org.koin.compose.koinInject

@Composable
fun OnboardingScreen(navController: NavController,viewModel: OnboardingViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(initialPage = 0) { pages.size }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnboardingPage(page = pages[index], modifier = Modifier.fillMaxSize())
        }

        Column(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = Medium_Padding_2)
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PageIndicator(
                    modifier = Modifier.width(Page_Indicator_Width),
                    pageSize = pages.size,
                    selectedPage = pagerState.currentPage
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    val scope = rememberCoroutineScope()

                    if (buttonState.value[0].isNotEmpty()) {
                        NewsTextButton(
                            buttonState.value[0],
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        )
                    }

                    NewsButton(
                        text = buttonState.value[1],
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage == pages.size-1) {
                                    //save in local store that user has entered
                                    viewModel.saveUserEntry(value = true){
                                        navController.navigate(Routes.NewsScreen)
                                    }

                                } else {
                                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                                }
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(Small_Padding_1))

        }

    }
}
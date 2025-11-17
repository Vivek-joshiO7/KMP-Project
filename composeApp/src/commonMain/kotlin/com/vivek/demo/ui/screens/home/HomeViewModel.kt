package com.vivek.demo.ui.screens.home

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.demo.data.remote.Resource
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.usecase.GetNewsUseCase
import com.vivek.demo.ui.screens.common.Publisher
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.app_name
import kmp_project.composeapp.generated.resources.developer_name
import kmp_project.composeapp.generated.resources.dummy_desc
import kmp_project.composeapp.generated.resources.img_onboarding_one
import kmp_project.composeapp.generated.resources.img_onboarding_three
import kmp_project.composeapp.generated.resources.img_onboarding_two
import kmp_project.composeapp.generated.resources.profile_name
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

class HomeViewModel(
    private val newsUseCase: GetNewsUseCase
) : ViewModel() {

    private val listOfCardItems : List<CardItems> = mutableListOf(
        CardItems(
            image = Res.drawable.img_onboarding_one,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        ),
        CardItems(
            image = Res.drawable.img_onboarding_two,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        ),
        CardItems(
            image = Res.drawable.img_onboarding_three,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        ),
        CardItems(
            image = Res.drawable.img_onboarding_one,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        ),
        CardItems(
            image = Res.drawable.img_onboarding_two,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        ),
        CardItems(
            image = Res.drawable.img_onboarding_three,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        ),
        CardItems(
            image = Res.drawable.img_onboarding_one,
            title = Res.string.app_name,
            desc = Res.string.dummy_desc,
            publisher = Publisher(
                name = Res.string.developer_name,
                profileImage = Res.drawable.img_onboarding_two,
                profileName = Res.string.profile_name
            )
        )
    )
    private val _getNews = MutableStateFlow<List<News>>(emptyList())
    val getNews: StateFlow<List<News>> = _getNews

    private val _getItems = MutableStateFlow(listOfCardItems)
    val getItems: StateFlow<List<CardItems>> = _getItems


    init {
        viewModelScope.launch {
            newsUseCase.invoke().let {
                when (it) {
                    is Resource.Success -> {
                        _getNews.value = it.data ?: emptyList()
                    }

                    is Resource.Error -> {
                        // Handle error case, e.g., log the error or show a message
                    }

                    is Resource.Loading -> {
                        // Handle loading state if necessary
                    }
                }
            }
        }
    }

}
package com.vivek.demo.ui.screens.news_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.demo.data.remote.Resource
import com.vivek.demo.data.remote.dto.NewsResponseDto
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.usecase.GetNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _dataNews = MutableStateFlow<List<News>>(emptyList())
    val dataNews: StateFlow<List<News>> = _dataNews


    init {
        viewModelScope.launch {
            newsUseCase.invoke().let {
                when (it) {
                    is Resource.Success -> {
                        _dataNews.value = it.data ?: emptyList()
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
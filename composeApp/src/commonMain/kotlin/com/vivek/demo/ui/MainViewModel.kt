package com.vivek.demo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.usecase.GetNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel(), KoinComponent {
    //    private val getNewsUseCase: GetNewsUseCase by inject()
    private val _dataNews = MutableStateFlow<List<News>>(emptyList())
    val dataNews: StateFlow<List<News>> = _dataNews


    init {
        viewModelScope.launch {
//            _dataNews.value = getNewsUseCase.invoke()
        }
    }
}
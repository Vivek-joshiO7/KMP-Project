package com.vivek.demo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.usecase.GetNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    val dataNews_ = MutableStateFlow<List<News>>(emptyList())
    val dataNews : StateFlow<List<News>> = dataNews_

    init {
        viewModelScope.launch {
            dataNews_.value = getNewsUseCase.invoke()
        }
    }
}
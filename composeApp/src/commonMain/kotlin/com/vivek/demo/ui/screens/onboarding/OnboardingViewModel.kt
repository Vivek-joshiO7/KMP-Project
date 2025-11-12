package com.vivek.demo.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.demo.domain.usecase.local_store_settings.UserEntryUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val userEntryUseCases: UserEntryUseCases
) : ViewModel() {
    init {
        getUserEntry()
    }

    private val _userHasEntered = MutableStateFlow(false)
    val userHasEntered: StateFlow<Boolean> = _userHasEntered
    fun saveUserEntry(value: Boolean) {
        viewModelScope.launch {
            userEntryUseCases.saveUserEntry(value)
        }
    }

    private fun getUserEntry() {
        viewModelScope.launch {
            _userHasEntered.value = userEntryUseCases.getUserEntry()
        }
    }
}
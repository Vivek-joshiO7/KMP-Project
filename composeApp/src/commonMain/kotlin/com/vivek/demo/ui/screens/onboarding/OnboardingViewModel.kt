package com.vivek.demo.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.demo.domain.usecase.local_store_settings.UserEntryUseCases
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val userEntryUseCases: UserEntryUseCases
) : ViewModel() {

    fun saveUserEntry(value: Boolean,onSaved : () -> Unit) {
        viewModelScope.launch {
            userEntryUseCases.saveUserEntry(value).also {
                onSaved.invoke()
            }
        }
    }
}
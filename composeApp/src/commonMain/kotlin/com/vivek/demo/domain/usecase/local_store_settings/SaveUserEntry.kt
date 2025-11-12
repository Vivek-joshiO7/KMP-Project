package com.vivek.demo.domain.usecase.local_store_settings

import com.vivek.demo.domain.manager.LocalUserManager

class SaveUserEntry(
    val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(value: Boolean) {
        localUserManager.saveUserEntry(value)
    }
}
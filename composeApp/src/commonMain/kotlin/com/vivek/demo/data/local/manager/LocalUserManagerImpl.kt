package com.vivek.demo.data.local.manager

import com.russhwolf.settings.Settings
import com.vivek.demo.domain.manager.LocalUserManager
import com.vivek.demo.utils.Constants.USER_ENTRY_KEY

class LocalUserManagerImpl(private val localStoreSetting: Settings) : LocalUserManager {

    override suspend fun saveUserEntry(value: Boolean) {
        localStoreSetting.putBoolean(USER_ENTRY_KEY, value)
    }

    override fun getUserEntry(): Boolean {
        return localStoreSetting.getBoolean(USER_ENTRY_KEY, false)
    }
}
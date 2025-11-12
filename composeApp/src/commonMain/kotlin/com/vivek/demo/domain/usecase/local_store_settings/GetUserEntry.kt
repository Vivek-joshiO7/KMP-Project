package com.vivek.demo.domain.usecase.local_store_settings

import com.vivek.demo.domain.manager.LocalUserManager

class GetUserEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Boolean {
        return localUserManager.getUserEntry()
    }
}
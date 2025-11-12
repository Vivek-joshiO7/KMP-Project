package com.vivek.demo.domain.manager

interface LocalUserManager {

    suspend fun saveUserEntry(value: Boolean)

    fun getUserEntry(): Boolean

}
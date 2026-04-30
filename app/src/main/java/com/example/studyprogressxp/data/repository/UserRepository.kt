package com.example.studyprogressxp.data.repository


import com.example.studyprogressxp.data.local.datastore.UserPreferences

class UserRepository(private val prefs: UserPreferences) {

    suspend fun saveUser(name: String, path: String) {
        prefs.saveUser(name, path)
    }

    fun getUserName() = prefs.getUserName()

    fun getImagePath() = prefs.getImagePath()
}
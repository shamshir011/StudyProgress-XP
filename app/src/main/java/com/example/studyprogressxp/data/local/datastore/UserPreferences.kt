package com.example.studyprogressxp.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_prefs")

object Keys {
    val USER_NAME = stringPreferencesKey("user_name")
    val IMAGE_PATH = stringPreferencesKey("image_path")
}

class UserPreferences(private val context: Context) {

    suspend fun saveUser(name: String, imagePath: String) {
        context.dataStore.edit {
            it[Keys.USER_NAME] = name
            it[Keys.IMAGE_PATH] = imagePath
        }
    }

    fun getUserName() = context.dataStore.data.map {
        it[Keys.USER_NAME] ?: ""
    }

    fun getImagePath() = context.dataStore.data.map {
        it[Keys.IMAGE_PATH] ?: ""
    }
}
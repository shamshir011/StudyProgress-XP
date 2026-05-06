package com.example.studyprogressxp.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

class SessionPreferences(private val context: Context) {

    private val Context.dataStore by preferencesDataStore("session_prefs")

    companion object {
        val SKILL_ID = intPreferencesKey("skill_id")
        val TIME_LEFT = intPreferencesKey("time_left")
        val SESSION_MINUTES = intPreferencesKey("session_minutes")
        val IS_ACTIVE = booleanPreferencesKey("is_active")
    }

    suspend fun saveSession(
        skillId: Int,
        timeLeft: Int,
        sessionMinutes: Int,
        isActive: Boolean
    ) {
        context.dataStore.edit {
            it[SKILL_ID] = skillId
            it[TIME_LEFT] = timeLeft
            it[SESSION_MINUTES] = sessionMinutes
            it[IS_ACTIVE] = isActive
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { it.clear() }
    }

    val sessionData = context.dataStore.data
}
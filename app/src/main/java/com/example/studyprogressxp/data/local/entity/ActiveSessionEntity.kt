package com.example.studyprogressxp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "active_sessions")
data class ActiveSessionEntity(
    @PrimaryKey
    val skillId: Int,

    val timeLeft: Int = 0,
    val sessionMinutes: Int = 0,
    val totalSeconds: Int = 0,
    val isActive: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
)
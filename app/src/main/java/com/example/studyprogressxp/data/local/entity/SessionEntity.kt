package com.example.studyprogressxp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class SessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val skillId: Int,
    val date: String,
    val minutes: Int,
    val xp: Int
)
package com.example.studyprogressxp.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "skills")
data class SkillEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val imagePath: String?,
    val xp: Int,
    val level: Int,
    val goal: String,
    val streakDays: Int
)
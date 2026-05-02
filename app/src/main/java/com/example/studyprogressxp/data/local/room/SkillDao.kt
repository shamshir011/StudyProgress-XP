package com.example.studyprogressxp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {

    @Insert
    suspend fun insertSkill(skill: SkillEntity)

    @Query("SELECT * FROM skills")
    fun getAllSkills(): Flow<List<SkillEntity>>
}
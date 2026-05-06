package com.example.studyprogressxp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.studyprogressxp.data.local.entity.SessionEntity
import com.example.studyprogressxp.data.local.entity.SkillEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {

    @Insert
    suspend fun insertSkill(skill: SkillEntity)

    @Query("SELECT * FROM skills")
    fun getAllSkills(): Flow<List<SkillEntity>>

    @Query("SELECT * FROM skills WHERE id = :id")
    fun getSkillById(id: Int): Flow<SkillEntity>


    @Query("UPDATE skills SET xp = xp + :xpToAdd WHERE id = :id")
    suspend fun updateXp(id: Int, xpToAdd: Int)

    @Query("""
UPDATE skills 
SET xp = xp + :xp,
    studiedMinutes = studiedMinutes + :minutes
WHERE id = :id
""")
    suspend fun updateSession(id: Int, minutes: Int, xp: Int)



    @Insert
    suspend fun insertSession(session: SessionEntity)

    @Query("SELECT SUM(xp) FROM sessions WHERE date = :today")
    fun getTodayXp(today: String): Flow<Int?>

    @Query("SELECT SUM(minutes) FROM sessions WHERE date = :today")
    fun getTodayStudiedMinutes(today: String): Flow<Int?>

    @Query("SELECT SUM(xp) FROM skills")
    fun getTotalXp(): Flow<Int?>

    @Query("SELECT DISTINCT date FROM sessions ORDER BY date DESC")
    suspend fun getAllSessionDates(): List<String>
}
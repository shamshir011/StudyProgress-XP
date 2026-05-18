package com.example.studyprogressxp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.studyprogressxp.data.local.entity.SessionEntity
import com.example.studyprogressxp.data.local.entity.SkillEntity
import com.example.studyprogressxp.data.local.model.SessionInfo
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

//    @Query("""
//UPDATE skills
//SET xp = xp + :xp
//WHERE id = :id
//""")
//    suspend fun updateSession(id: Int, xp: Int)

    @Query("""
UPDATE skills
SET xp = xp + :xp,
    level = level + 1
WHERE id = :id
""")
    suspend fun updateSession(id: Int, xp: Int)



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


    @Query("UPDATE skills SET studiedMinutes = 0 WHERE id = :id")
    suspend fun resetSkillProgress(id: Int)

    @Query("UPDATE skills SET studiedMinutes = :minutes WHERE id = :id")
    suspend fun updateSkillProgress(id: Int, minutes: Int)

//    @Query("UPDATE skills SET timeLeftSeconds = :timeLeft, studiedMinutes = :studiedMinutes WHERE id = :id")
//    suspend fun updateSkillTimerProgress(
//        id: Int,
//        timeLeft: Int,
//        studiedMinutes: Int
//    )

    @Query("""
UPDATE skills 
SET timeLeftSeconds = :timeLeft,
    studiedMinutes = :studiedMinutes,
    totalStudiedMinutes = totalStudiedMinutes + :newMinutes
WHERE id = :id
""")
    suspend fun updateSkillTimerProgress(
        id: Int,
        timeLeft: Int,
        studiedMinutes: Int,
        newMinutes: Int
    )

    @Query("SELECT SUM(minutes) FROM sessions WHERE skillId = :skillId")
    fun getTotalStudiedMinutesBySkill(skillId: Int): Flow<Int?>


    @Query("""
SELECT minutes, createdAt 
FROM sessions 
WHERE skillId = :skillId 
ORDER BY minutes DESC 
LIMIT 1
""")
    fun getBestSession(skillId: Int): Flow<SessionInfo?>

    @Query("""
SELECT minutes, createdAt 
FROM sessions 
WHERE skillId = :skillId 
ORDER BY createdAt DESC 
LIMIT 1
""")
    fun getLastSession(skillId: Int): Flow<SessionInfo?>

}
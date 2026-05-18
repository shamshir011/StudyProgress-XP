package com.example.studyprogressxp.data.repository

import com.example.studyprogressxp.data.local.dao.SkillDao
import com.example.studyprogressxp.data.local.entity.SessionEntity
import com.example.studyprogressxp.data.local.entity.SkillEntity
import com.example.studyprogressxp.utils.getTodayDate

class SkillRepository(private val dao: SkillDao) {

    suspend fun insertSkill(skill: SkillEntity) {
        dao.insertSkill(skill)
    }

    fun getSkills() = dao.getAllSkills()
    fun getSkillById(id: Int) = dao.getSkillById(id)

    suspend fun updateXp(id: Int, xpToAdd: Int) {
        dao.updateXp(id, xpToAdd)
    }


    suspend fun updateSession(id: Int, minutes: Int, xp: Int) {
        dao.updateSession(id, xp)

        dao.insertSession(
            SessionEntity(
                skillId = id,
                date = getTodayDate(),
                minutes = minutes,
                xp = xp
            )
        )
    }


    fun getTodayXp(today: String) = dao.getTodayXp(today)

    fun getTodayStudiedMinutes(today: String) = dao.getTodayStudiedMinutes(today)

    fun getTotalXp() = dao.getTotalXp()


    suspend fun getAllSessionDates() = dao.getAllSessionDates()

    suspend fun resetSkillProgress(id: Int) {
        dao.resetSkillProgress(id)
    }

    suspend fun updateSkillProgress(id: Int, minutes: Int) {
        dao.updateSkillProgress(id, minutes)
    }

//    suspend fun updateSkillTimerProgress(id: Int, timeLeft: Int, studiedMinutes: Int) {
//        dao.updateSkillTimerProgress(id, timeLeft, studiedMinutes)
//    }

    suspend fun updateSkillTimerProgress(
        id: Int,
        timeLeft: Int,
        studiedMinutes: Int,
        newMinutes: Int
    ) {
        dao.updateSkillTimerProgress(
            id = id,
            timeLeft = timeLeft,
            studiedMinutes = studiedMinutes,
            newMinutes = newMinutes
        )
    }


    suspend fun insertStudySession(skillId: Int, minutes: Int, xp: Int) {
        dao.insertSession(
            SessionEntity(
                skillId = skillId,
                date = getTodayDate(),
                minutes = minutes,
                xp = xp
            )
        )
    }

    fun getTotalStudiedMinutesBySkill(skillId: Int) =
        dao.getTotalStudiedMinutesBySkill(skillId)

    fun getBestSession(skillId: Int) = dao.getBestSession(skillId)

    fun getLastSession(skillId: Int) = dao.getLastSession(skillId)
}
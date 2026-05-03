package com.example.studyprogressxp.data.repository

import com.example.studyprogressxp.data.local.room.SkillDao
import com.example.studyprogressxp.data.local.room.SkillEntity

class SkillRepository(private val dao: SkillDao) {

    suspend fun insertSkill(skill: SkillEntity) {
        dao.insertSkill(skill)
    }

    fun getSkills() = dao.getAllSkills()
    fun getSkillById(id: Int) = dao.getSkillById(id)

    suspend fun updateXp(id: Int, xpToAdd: Int) {
        dao.updateXp(id, xpToAdd)
    }
}
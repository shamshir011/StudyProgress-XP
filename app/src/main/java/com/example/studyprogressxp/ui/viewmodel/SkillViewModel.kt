package com.example.studyprogressxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprogressxp.data.local.room.SkillEntity
import com.example.studyprogressxp.data.repository.SkillRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SkillViewModel(private val repo: SkillRepository) : ViewModel() {

    val skills = repo.getSkills().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )


    fun addSkill(
        name: String,
        imagePath: String,
        goal: String,
        xp: Int,
        onDone: () -> Unit
    ) {
        viewModelScope.launch {
            repo.insertSkill(
                SkillEntity(
                    name = name,
                    imagePath = imagePath,
                    xp = xp,
                    level = 1,                 // default start
                    goal = goal, // convert if needed
                    streakDays = 0             // start fresh
                )
            )
            onDone() //  after insert completes
        }
    }

    fun getSkillById(id: Int) = repo.getSkillById(id)

    fun updateXp(id: Int, xpToAdd: Int) {
        viewModelScope.launch {
            repo.updateXp(id, xpToAdd)
        }
    }
}
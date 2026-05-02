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

//    fun addSkill(name: String, imagePath: String, goal: String, xp: Int) {
//        viewModelScope.launch {
//            repo.insertSkill(
//                SkillEntity(
//                    name = name,
//                    imagePath = imagePath,
//                    goal = goal,
//                    xp = xp
//                )
//            )
//        }
//    }


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
                    goal = goal,
                    xp = xp
                )
            )
            onDone() // 👈 after insert completes
        }
    }
}
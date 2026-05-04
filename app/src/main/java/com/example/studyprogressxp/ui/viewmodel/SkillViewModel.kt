package com.example.studyprogressxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprogressxp.data.local.room.SkillEntity
import com.example.studyprogressxp.data.repository.SkillRepository
import com.example.studyprogressxp.ui.screens.session.SessionUiState
import com.example.studyprogressxp.utils.goalToMinutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SkillViewModel(private val repo: SkillRepository) : ViewModel() {

    val skills = repo.getSkills().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    private val _sessionState = MutableStateFlow(SessionUiState())
    val sessionState = _sessionState.asStateFlow()



    fun toggleTimer() {
        val current = _sessionState.value
        _sessionState.value = current.copy(isRunning = !current.isRunning)

        if (_sessionState.value.isRunning) {
            runTimer()
        }
    }




    private fun runTimer() {
        viewModelScope.launch {
            while (_sessionState.value.isRunning &&
                _sessionState.value.timeLeft > 0) {

                delay(1000)

                val state = _sessionState.value
                val newTime = state.timeLeft - 1

                val progress = 1f - (newTime.toFloat() / state.totalSeconds)
                val percent = (progress * 100).toInt()

                val sessionMinutes = (state.totalSeconds * progress / 60).toInt()
                val totalMinutes = state.baseMinutes + sessionMinutes

                _sessionState.value = state.copy(
                    timeLeft = newTime,
                    progress = progress,
                    percent = percent,
                    sessionMinutes = sessionMinutes,
                    studiedMinutes = totalMinutes
                )

                if (newTime == 0) {
                    completeSession(
                        id = state.skillId,
                        minutes = state.studiedMinutes,
                        xp = 30
                    )
                }
            }
        }
    }



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
                    streakDays = 0,             // start fresh
                    studiedMinutes = 0
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

//    fun completeSession(id: Int, minutes: Int, xp: Int) {
//        viewModelScope.launch {
//            repo.updateSession(id, minutes, xp)
//        }
//    }

    fun completeSession(id: Int, minutes: Int, xp: Int) {
        viewModelScope.launch {

            val state = _sessionState.value

            // prevent double save
            if (!state.isRunning) return@launch

            _sessionState.value = state.copy(isRunning = false)

            repo.updateSession(id, minutes, xp)
        }
    }


    fun startSession(skill: SkillEntity) {
        val current = _sessionState.value

        //  Prevent re-initializing same skill
        if (current.skillId == skill.id) return

        val totalSeconds = goalToMinutes(skill.goal) * 60

        _sessionState.value = SessionUiState(
            skillId = skill.id,
            skillName = skill.name,
            goal = skill.goal,
            totalSeconds = totalSeconds,
            timeLeft = totalSeconds,
            studiedMinutes = skill.studiedMinutes,
            baseMinutes = skill.studiedMinutes
        )
    }

    fun resetTimer() {
        val state = _sessionState.value


        _sessionState.value = state.copy(
            isRunning = false,
            timeLeft = state.totalSeconds,
            progress = 0f,
            percent = 0,
            sessionMinutes = 0,
            studiedMinutes = state.baseMinutes //  keep DB progress
        )
    }
}
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
    val newRunning = !current.isRunning

    _sessionState.value = current.copy(isRunning = newRunning)

    if (newRunning) {
        runTimer()
    }
}
    private fun runTimer() {
        viewModelScope.launch {

            while (true) {

                val state = _sessionState.value

                if (!state.isRunning || state.timeLeft <= 0) break

                val newTime = state.timeLeft - 1

                val elapsedSeconds = state.totalSeconds - newTime

                val sessionMinutes = elapsedSeconds / 60   // ✅ safe conversion

                val progress = elapsedSeconds.toFloat() / state.totalSeconds
                val percent = (progress * 100).toInt()

                _sessionState.value = state.copy(
                    timeLeft = newTime,
                    progress = progress,
                    percent = percent,
                    sessionMinutes = sessionMinutes,
                    studiedMinutes = state.baseMinutes + sessionMinutes
                )


                if (newTime == 0) {
                    completeSession(
                        id = state.skillId,
//                        minutes = state.sessionMinutes,
                        minutes = sessionMinutes,
                        xp = state.rewardXp
                    )
                    break
                }

                delay(1000)
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
                    level = 1,
                    goal = goal,
                    streakDays = 0,
                    studiedMinutes = 0
                )
            )
            onDone()
        }
    }

    fun getSkillById(id: Int) = repo.getSkillById(id)

    fun updateXp(id: Int, xpToAdd: Int) {
        viewModelScope.launch {
            repo.updateXp(id, xpToAdd)
        }
    }


    fun completeSession(id: Int, minutes: Int, xp: Int) {
        val state = _sessionState.value

        if (!state.isRunning && state.sessionMinutes == 0) return

        viewModelScope.launch {
            _sessionState.value = state.copy(
                isRunning = false,
                sessionMinutes = 0
            )

            repo.updateSession(id, minutes, xp)
        }
    }


    fun startSession(skill: SkillEntity) {

        val current = _sessionState.value

        if (current.skillId == skill.id) return

        val totalSeconds = goalToMinutes(skill.goal) * 60

        _sessionState.value = SessionUiState(
            skillId = skill.id,
            skillName = skill.name,
            goal = skill.goal,
            totalSeconds = totalSeconds,
            timeLeft = totalSeconds,
            baseMinutes = skill.studiedMinutes,
            studiedMinutes = skill.studiedMinutes,
            sessionMinutes = 0,
            rewardXp = skill.xp
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
            studiedMinutes = state.baseMinutes
        )
    }
}
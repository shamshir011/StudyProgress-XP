package com.example.studyprogressxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprogressxp.data.local.datastore.SessionPreferences
import com.example.studyprogressxp.data.local.entity.SkillEntity
import com.example.studyprogressxp.data.repository.SkillRepository
import com.example.studyprogressxp.ui.screens.session.SessionUiState
import com.example.studyprogressxp.utils.goalToMinutes
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.example.studyprogressxp.utils.calculateStreak
import com.example.studyprogressxp.utils.getLevelFromXp
import com.example.studyprogressxp.utils.getRequiredXpForLevel
import com.example.studyprogressxp.utils.getLevelTitle
import com.example.studyprogressxp.utils.getTodayDate


class SkillViewModel(
    private val repo: SkillRepository,
    private val sessionPrefs: SessionPreferences
) : ViewModel() {

    val skills = repo.getSkills().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    private val _sessionState = MutableStateFlow(SessionUiState())
    val sessionState = _sessionState.asStateFlow()
    private var timerJob: Job? = null


    val todayXp = repo.getTodayXp(getTodayDate())
        .map { it ?: 0 }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val todayMinutes = repo.getTodayStudiedMinutes(getTodayDate())
        .map { it ?: 0 }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val totalXp = repo.getTotalXp()
        .map { it ?: 0 }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)


    private val _streakDays = MutableStateFlow(0)
    val streakDays = _streakDays.asStateFlow()

    init {
        loadStreak()
    }


    val level = totalXp
        .map { xp -> getLevelFromXp(xp) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 1)

    val levelTitle = level
        .map { currentLevel -> getLevelTitle(currentLevel) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "Beginner Scholar")

    val nextLevelXp = level
        .map { currentLevel -> getRequiredXpForLevel(currentLevel + 1) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 500)


fun toggleTimer() {
    val current = _sessionState.value
    val newRunning = !current.isRunning

    _sessionState.value = current.copy(isRunning = newRunning)

    if (newRunning) {
        runTimer()
    }
}
    private fun runTimer() {

        timerJob?.cancel()

        timerJob = viewModelScope.launch {

            while (_sessionState.value.isRunning &&
                _sessionState.value.timeLeft > 0) {



                val state = _sessionState.value
                val newTime = state.timeLeft - 1

                val elapsedSeconds = state.totalSeconds - newTime

                val sessionMinutes = (elapsedSeconds / 60)
                    .coerceAtMost(goalToMinutes(state.goal))

                val progress = elapsedSeconds.toFloat() / state.totalSeconds
                val percent = (progress * 100).toInt().coerceAtMost(100)

                _sessionState.value = state.copy(
                    timeLeft = newTime,
                    progress = progress,
                    percent = percent,
                    sessionMinutes = sessionMinutes,
                    studiedMinutes = state.baseMinutes + sessionMinutes
                )

                repo.updateSkillTimerProgress(
                    id = state.skillId,
                    timeLeft = newTime,
                    studiedMinutes = state.baseMinutes + sessionMinutes
                )

                sessionPrefs.saveSession(
                    skillId = state.skillId,
                    timeLeft = newTime,
                    sessionMinutes = sessionMinutes,
                    isActive = true
                )

                if (newTime == 0) {
                    completeSession(
                        id = state.skillId,
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
                    level = 1,
                    goal = goal,
                    streakDays = 0,
                    studiedMinutes = 0,
                    xp = 0,
                    goalXp = xp,
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

        timerJob?.cancel()

        viewModelScope.launch {
            _sessionState.value = state.copy(
                isRunning = false,
                sessionMinutes = 0
            )

            repo.updateSession(id, minutes, xp)

            // reset skill card progress after goal complete
            repo.resetSkillProgress(id)
            // goal completed or stop clicked = clear saved running session
            sessionPrefs.clearSession()
        }
    }


    fun startSession(skill: SkillEntity) {
        val current = _sessionState.value

        // Prevent unnecessary reset if already on same skill
        if (current.skillId == skill.id && current.totalSeconds > 0) return

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
            rewardXp = skill.goalXp,
            isRunning = false
        )
    }



//    New Added
    fun resetTimer() {
        timerJob?.cancel()

        val state = _sessionState.value

        _sessionState.value = state.copy(
            isRunning = false,
            timeLeft = state.totalSeconds,
            progress = 0f,
            percent = 0,
            sessionMinutes = 0,
            studiedMinutes = 0,
            baseMinutes = 0
        )

        viewModelScope.launch {
            repo.updateSkillProgress(
                id = state.skillId,
                minutes = 0
            )

            sessionPrefs.clearSession()
        }
    }

//Just Comment
//    fun restoreSavedSession(skill: SkillEntity) {
//        viewModelScope.launch {
//            val prefs = sessionPrefs.sessionData.first()
//
//            val savedSkillId = prefs[SessionPreferences.SKILL_ID]
//            val savedTimeLeft = prefs[SessionPreferences.TIME_LEFT]
//            val savedSessionMinutes = prefs[SessionPreferences.SESSION_MINUTES] ?: 0
//
//            if (savedSkillId == skill.id && savedTimeLeft != null && savedTimeLeft > 0) {
//                restoreSession(
//                    skill = skill,
//                    savedTimeLeft = savedTimeLeft,
//                    savedSessionMinutes = savedSessionMinutes
//                )
//            } else {
//                // === KEY FIX ===
//                if (savedSkillId != null && savedSkillId != skill.id) {
//                    sessionPrefs.clearSession()   // Clear previous skill's paused session
//                }
//
//                startSession(skill)   // Fresh start for new skill
//            }
//        }
//    }

    fun restoreSavedSession(skill: SkillEntity) {
        val totalSeconds = goalToMinutes(skill.goal) * 60

        val timeLeft = if (skill.timeLeftSeconds > 0) {
            skill.timeLeftSeconds
        } else {
            totalSeconds
        }

        val elapsedSeconds = totalSeconds - timeLeft
        val progress = (elapsedSeconds.toFloat() / totalSeconds).coerceIn(0f, 1f)

        _sessionState.value = SessionUiState(
            skillId = skill.id,
            skillName = skill.name,
            goal = skill.goal,
            totalSeconds = totalSeconds,
            timeLeft = timeLeft,
            progress = progress,
            percent = (progress * 100).toInt(),
            baseMinutes = skill.studiedMinutes,
            studiedMinutes = skill.studiedMinutes,
            sessionMinutes = 0,
            rewardXp = skill.goalXp,
            isRunning = false
        )
    }


    fun restoreSession(
        skill: SkillEntity,
        savedTimeLeft: Int,
        savedSessionMinutes: Int
    ) {
        val totalSeconds = goalToMinutes(skill.goal) * 60

        val elapsedSeconds = totalSeconds - savedTimeLeft

        val progress = (elapsedSeconds.toFloat() / totalSeconds)
            .coerceIn(0f, 1f)

        _sessionState.value = SessionUiState(
            skillId = skill.id,
            skillName = skill.name,
            goal = skill.goal,
            totalSeconds = totalSeconds,
            timeLeft = savedTimeLeft,
            progress = progress,
            percent = (progress * 100).toInt(),
            baseMinutes = skill.studiedMinutes,
            sessionMinutes = savedSessionMinutes,
            studiedMinutes = skill.studiedMinutes + savedSessionMinutes,
            rewardXp = skill.goalXp,
            isRunning = false
        )
    }

//    fun stopSession() {
//        timerJob?.cancel()
//
//        val state = _sessionState.value
//
//        _sessionState.value = state.copy(
//            isRunning = false
//        )
//
//        viewModelScope.launch {
//
//            // SAVE CURRENT REMAINING TIME
//            sessionPrefs.saveSession(
//                skillId = state.skillId,
//                timeLeft = state.timeLeft,
//                sessionMinutes = state.sessionMinutes,
//                isActive = true
//            )
//        }
//    }



//    Just commented
//    fun stopSession() {
//        timerJob?.cancel()
//
//        val state = _sessionState.value
//
//        _sessionState.value = state.copy(isRunning = false)
//
//        viewModelScope.launch {
//            sessionPrefs.saveSession(
//                skillId = state.skillId,
//                timeLeft = state.timeLeft,
//                sessionMinutes = state.sessionMinutes,
//                isActive = true
//            )
//        }
//    }


//    Just added
    fun stopSession() {
        timerJob?.cancel()

        val state = _sessionState.value

        _sessionState.value = state.copy(isRunning = false)

        viewModelScope.launch {

            // save timer/progress for this specific skill
            repo.updateSkillTimerProgress(
                id = state.skillId,
                timeLeft = state.timeLeft,
                studiedMinutes = state.studiedMinutes
            )

            // save today studied time
            if (state.sessionMinutes > 0) {
                repo.insertStudySession(
                    skillId = state.skillId,
                    minutes = state.sessionMinutes,
                    xp = 0
                )
            }

            sessionPrefs.saveSession(
                skillId = state.skillId,
                timeLeft = state.timeLeft,
                sessionMinutes = state.sessionMinutes,
                isActive = true
            )
        }
    }


    fun loadStreak() {

        viewModelScope.launch {

            val dates = repo.getAllSessionDates()

            _streakDays.value = calculateStreak(dates)
        }
    }
}
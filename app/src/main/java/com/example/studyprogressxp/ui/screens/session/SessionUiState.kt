package com.example.studyprogressxp.ui.screens.session

data class SessionUiState(
    val skillId: Int = 0,
    val skillName: String = "",
    val goal: String = "",
    val totalSeconds: Int = 0,
    val timeLeft: Int = 0,
    val progress: Float = 0f,
    val percent: Int = 0,
    val studiedMinutes: Int = 0,
    val isRunning: Boolean = false,
    val baseMinutes: Int = 0,
    val sessionMinutes: Int = 0,
    val rewardXp: Int = 0
)
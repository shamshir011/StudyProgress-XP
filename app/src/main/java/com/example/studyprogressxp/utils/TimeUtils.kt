package com.example.studyprogressxp.utils


fun goalToMinutes(goal: String): Int {
    return when (goal) {
        "30m" -> 30
        "1h" -> 60
        "2h" -> 120
        else -> 60
    }
}
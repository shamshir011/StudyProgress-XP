package com.example.studyprogressxp.utils


fun goalToMinutes(goal: String): Int {
    return when (goal) {
        "1m" -> 1
        "1h" -> 60
        "2h" -> 120
        else -> 60
    }
}

fun getTodayDate(): String {
    return java.time.LocalDate.now().toString()
}
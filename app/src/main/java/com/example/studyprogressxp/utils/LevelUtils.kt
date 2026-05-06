package com.example.studyprogressxp.utils

fun getRequiredXpForLevel(level: Int): Int {
    return when (level) {
        1 -> 0
        2 -> 500
        3 -> 1200
        4 -> 2200
        5 -> 3500
        6 -> 5000
        7 -> 7000
        8 -> 9500
        9 -> 12500
        10 -> 16000
        else -> 16000 + ((level - 10) * 4000)
    }
}

fun getLevelFromXp(totalXp: Int): Int {
    var level = 1

    while (totalXp >= getRequiredXpForLevel(level + 1)) {
        level++
    }

    return level
}

fun getLevelTitle(level: Int): String {
    return when (level) {
        1 -> "Beginner Scholar"
        2 -> "Focused Learner"
        3 -> "Focused Scholar"
        4 -> "Deep Worker"
        5 -> "Knowledge Builder"
        6 -> "Discipline Master"
        7 -> "Study Warrior"
        8 -> "Mindful Expert"
        9 -> "Learning Champion"
        10 -> "Master Scholar"
        else -> "Legend Scholar"
    }
}
package com.example.studyprogressxp.utils


import java.time.LocalDate

fun calculateStreak(dates: List<String>): Int {

    if (dates.isEmpty()) return 0

    val uniqueDates = dates
        .map { LocalDate.parse(it) }
        .distinct()
        .sortedDescending()

    val today = LocalDate.now()

    // if user missed today and yesterday also → streak 0
    if (
        uniqueDates.first() != today &&
        uniqueDates.first() != today.minusDays(1)
    ) {
        return 0
    }

    var streak = 1

    for (i in 0 until uniqueDates.size - 1) {

        val current = uniqueDates[i]
        val next = uniqueDates[i + 1]

        if (current.minusDays(1) == next) {
            streak++
        } else {
            break
        }
    }

    return streak
}
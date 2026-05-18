package com.example.studyprogressxp.utils

fun goalToMinutes(goal: String): Int {
    return when (goal) {
        "1m" -> 1
        "1h" -> 60
        "2h" -> 120
        else -> 60
    }
}

fun formatMinutes(minutes: Int): String {

    val hours = minutes / 60
    val mins = minutes % 60

    return when {
        hours > 0 && mins > 0 -> "${hours}h ${mins}m"
        hours > 0 -> "${hours}h"
        else -> "${mins}m"
    }

}

fun formatStudyTime(minutes: Int): String {
    val hours = minutes / 60
    val mins = minutes % 60

    return if (hours == 0) {
        "0.${mins}h"
    } else if (mins == 0) {
        "${hours}h"
    } else {
        "${hours}.${mins}h"
    }
}

fun getTodayDate(): String {
    return java.time.LocalDate.now().toString()
}



fun formatDateTime(timeMillis: Long?): String {
    if (timeMillis == null) return "Not studied yet"

    val dateTime = java.time.Instant.ofEpochMilli(timeMillis)
        .atZone(java.time.ZoneId.systemDefault())
        .toLocalDateTime()

    val today = java.time.LocalDate.now()

    val time = dateTime.toLocalTime()
        .format(java.time.format.DateTimeFormatter.ofPattern("h:mm a"))

    return if (dateTime.toLocalDate() == today) {
        "Today, $time"
    } else {
        dateTime.format(java.time.format.DateTimeFormatter.ofPattern("MMM dd, h:mm a"))
    }
}
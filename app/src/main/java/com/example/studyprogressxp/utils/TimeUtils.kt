package com.example.studyprogressxp.utils


//fun goalToMinutes(goal: String): Int {
//    return when (goal) {
//        "1m" -> 1
//        "1h" -> 60
//        "2h" -> 120
//        else -> 60
//    }
//}

//fun getTodayDate(): String {
//    return java.time.LocalDate.now().toString()
//}

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

fun getTodayDate(): String {
    return java.time.LocalDate.now().toString()
}
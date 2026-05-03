package com.example.studyprogressxp.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavBarRoutes {
    @Serializable
    object Home : NavBarRoutes()

    @Serializable
    object Stats : NavBarRoutes()

    @Serializable
    object Profile : NavBarRoutes()

    @Serializable
    object Settings : NavBarRoutes()

//    @Serializable
//    object Session : NavBarRoutes()
    @Serializable
    data class Session(val skillId: Int) : NavBarRoutes()

    @Serializable
    object AddNewSkill : NavBarRoutes()

    //    @Serializable
//    object Skills : NavBarRoutes()
    @Serializable
    data class Skills(val skillId: Int) : NavBarRoutes()

    @Serializable
    object UserEntry : NavBarRoutes()
}
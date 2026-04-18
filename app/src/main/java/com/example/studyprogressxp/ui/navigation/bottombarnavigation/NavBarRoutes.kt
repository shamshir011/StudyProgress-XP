package com.example.studyprogressxp.ui.navigation.bottombarnavigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavBarRoutes{
    @Serializable
    object Home : NavBarRoutes()

    @Serializable
    object Stats: NavBarRoutes()

    @Serializable
    object Profile : NavBarRoutes()

    @Serializable
    object Settings : NavBarRoutes()

    @Serializable
    object Session : NavBarRoutes()
}
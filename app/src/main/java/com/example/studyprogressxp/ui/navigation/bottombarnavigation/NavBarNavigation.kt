package com.example.studyprogressxp.ui.navigation.bottombarnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studyprogressxp.ui.screens.homescreen.HomeScreen
import com.example.studyprogressxp.ui.screens.profilescreen.ProfileScreen
import com.example.studyprogressxp.ui.screens.statsscreen.StatsScreen

@Composable
fun NavBarNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavBarRoutes.Home
    ){

        composable<NavBarRoutes.Home>{
            HomeScreen(navController)
        }

        composable<NavBarRoutes.Stats> {
            StatsScreen(navController)
        }

        composable<NavBarRoutes.Profile> {
            ProfileScreen(navController)
        }
    }
}
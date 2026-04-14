package com.example.studyprogressxp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studyprogressxp.ui.components.AppBottomBar
import com.example.studyprogressxp.ui.components.AppTopBarUI
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.MyNavBar
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.NavBarRoutes
import com.example.studyprogressxp.ui.screens.homescreen.HomeScreen
import com.example.studyprogressxp.ui.screens.profilescreen.ProfileScreen
import com.example.studyprogressxp.ui.screens.statsscreen.StatsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBarUI() },
        bottomBar = { MyNavBar(navController) }
    ) { innerPadding->

        NavHost(
            navController = navController,
            startDestination = NavBarRoutes.Home,
            modifier = Modifier.padding(innerPadding)
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
}
package com.example.studyprogressxp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.studyprogressxp.ui.components.AppTopBarUI
import com.example.studyprogressxp.ui.components.SettingTopBar
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.MyNavBar
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.NavBarRoutes
import com.example.studyprogressxp.ui.screens.homescreen.HomeScreen
import com.example.studyprogressxp.ui.screens.profilescreen.ProfileScreen
import com.example.studyprogressxp.ui.screens.settingscreen.SettingScreen
import com.example.studyprogressxp.ui.screens.statsscreen.StatsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    val hideRoutes = listOf("Settings")

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    val hideBottomBarRoutes = listOf(
        NavBarRoutes.Settings::class.simpleName
    )

    Scaffold(

        topBar = {

            when{
                currentRoute?.contains("Settings") == true -> {
                    SettingTopBar(navController)
                }
                else->{
                    AppTopBarUI(navController)}
                }
            },



        bottomBar = {
            val shouldHide = hideRoutes.any {
                currentRoute?.contains(it) == true
            }

            if (!shouldHide) {
                MyNavBar(navController)
            }
        }
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

            composable<NavBarRoutes.Settings> {
                SettingScreen(navController)
            }
        }
    }
}
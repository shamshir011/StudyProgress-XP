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
import com.example.studyprogressxp.ui.components.topappbar.AddNewSkillTopAppBar
import com.example.studyprogressxp.ui.components.topappbar.AppTopBarUI
import com.example.studyprogressxp.ui.components.topappbar.SettingTopBar
import com.example.studyprogressxp.ui.components.bottomappbar.MyNavBar
import com.example.studyprogressxp.ui.components.topappbar.SessionTopAppBar
import com.example.studyprogressxp.ui.components.topappbar.SpecificSkillTopBar
import com.example.studyprogressxp.ui.screens.addnewskill.AddNewSkill
import com.example.studyprogressxp.ui.screens.home.HomeScreen
import com.example.studyprogressxp.ui.screens.profile.ProfileScreen
import com.example.studyprogressxp.ui.screens.session.SessionScreen
import com.example.studyprogressxp.ui.screens.setting.SettingScreen
import com.example.studyprogressxp.ui.screens.spacificskill.Skill
import com.example.studyprogressxp.ui.screens.stats.StatsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    val hideRoutes = listOf("Settings", "Session", "AddNewSkill", "Session", "Skills")

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route



    Scaffold(

        topBar = {

            when{
                currentRoute?.contains("Settings") == true -> {
                    SettingTopBar(navController)
                }

                currentRoute?.contains("AddNewSkill") == true -> {
                    AddNewSkillTopAppBar(navController)
                }
                currentRoute?.contains("Session") == true -> {
                    SessionTopAppBar(navController)
                }

                currentRoute?.contains("Skills") == true -> {
                    SpecificSkillTopBar(navController)
                }
                else->{
                    AppTopBarUI(navController)
                }
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

            composable<NavBarRoutes.Stats>{
                StatsScreen(navController)
            }

            composable<NavBarRoutes.Profile>{
                ProfileScreen(navController)
            }

            composable<NavBarRoutes.Settings>{
                SettingScreen(navController)
            }

            composable<NavBarRoutes.Session> {
                SessionScreen(navController)
            }

            composable<NavBarRoutes.AddNewSkill>{
                AddNewSkill(navController)
            }

            composable<NavBarRoutes.Skills>{
                Skill(navController)
            }
        }
    }
}
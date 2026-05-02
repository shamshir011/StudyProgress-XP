package com.example.studyprogressxp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.studyprogressxp.data.local.datastore.UserPreferences
import com.example.studyprogressxp.data.local.room.AppDatabase
import com.example.studyprogressxp.data.repository.SkillRepository
import com.example.studyprogressxp.data.repository.UserRepository
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
import com.example.studyprogressxp.ui.screens.userentry.UserEntry
import com.example.studyprogressxp.ui.viewmodel.SkillViewModel
import com.example.studyprogressxp.ui.viewmodel.SkillViewModelFactory
import com.example.studyprogressxp.ui.viewmodel.UserViewModel
import com.example.studyprogressxp.ui.viewmodel.UserViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val context = LocalContext.current

    val prefs = UserPreferences(context)
    val repo = UserRepository(prefs)

    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(repo)
    )

    val db = AppDatabase.getDatabase(context)
    val skillRepo = SkillRepository(db.skillDao())

    val skillViewModel: SkillViewModel = viewModel(
        factory = SkillViewModelFactory(skillRepo)
    )

// load once
    LaunchedEffect(Unit) {
        userViewModel.loadUser()
    }

    val hideRoutes = listOf("Settings", "Session", "AddNewSkill", "Session", "Skills", "UserEntry")

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    Scaffold(

        topBar = {

            when {
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

                currentRoute?.contains("UserEntry") == true -> {
                    UserEntry(navController, userViewModel)
                }

                else -> {
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
    ) { innerPadding ->




        if (!userViewModel.isLoaded) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {

            val startDestination = if (userViewModel.userName.isEmpty()) {
                NavBarRoutes.UserEntry
            } else {
                NavBarRoutes.Home
            }

            NavHost(
                navController = navController,
                startDestination = startDestination,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable<NavBarRoutes.Home> {
                    HomeScreen(navController)
                }

                composable<NavBarRoutes.Stats> {
                    StatsScreen(navController)
                }

                composable<NavBarRoutes.Profile> {
                    ProfileScreen(navController, userViewModel)
                }

                composable<NavBarRoutes.Settings> {
                    SettingScreen(navController, userViewModel)
                }

                composable<NavBarRoutes.Session> {
                    SessionScreen(navController)
                }

                composable<NavBarRoutes.AddNewSkill> {
                    AddNewSkill(navController, skillViewModel)
                }

                composable<NavBarRoutes.Skills> {
                    Skill(navController)
                }

                composable<NavBarRoutes.UserEntry> {
                    UserEntry(navController, userViewModel)
                }
            }
        }
    }
}
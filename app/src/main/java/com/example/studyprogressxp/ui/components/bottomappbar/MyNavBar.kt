package com.example.studyprogressxp.ui.components.bottomappbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.Purple

@Composable
fun MyNavBar(navController: NavHostController) {

    val navItems = listOf(
        NavItem("Home", R.drawable.home_icon, NavBarRoutes.Home),
        NavItem("Stats", R.drawable.stats_icon, NavBarRoutes.Stats),
        NavItem("Profile", R.drawable.profile_icon, NavBarRoutes.Profile)
    )

    val currentDestination =
        navController.currentBackStackEntryAsState().value?.destination


    NavigationBar {

        navItems.forEach { item ->

            val navBackStackEntry by navController.currentBackStackEntryAsState()

            val isSelected = when (item.routes) {

                is NavBarRoutes.Home ->
                    currentDestination?.route?.contains("Home") == true

                is NavBarRoutes.Stats ->
                    currentDestination?.route?.contains("Stats") == true

                is NavBarRoutes.Profile ->
                    currentDestination?.route?.contains("Profile") == true

                is NavBarRoutes.Skills ->
                    currentDestination?.route?.contains("Skills") == true

                else -> false

            }

            NavigationBarItem(
//                selected = item.title == key,
                selected = isSelected,
                onClick = {
                    navController.navigate(item.routes){
//                        Its handling backStack
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = "Home"
                    )
                },
                label = { Text(text = item.title) },
//                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = Purple,
                    selectedIconColor = Purple,
                    indicatorColor = Purple.copy(alpha = 0.1f),
                    unselectedTextColor = Color.DarkGray,
                    unselectedIconColor = Color.DarkGray
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int,
    val routes: NavBarRoutes
)
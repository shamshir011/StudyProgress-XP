package com.example.studyprogressxp.ui.navigation.bottombarnavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.studyprogressxp.R

@Composable
fun MyNavBar(navController: NavHostController, key: String) {

    val navItems = listOf(
        NavItem("Home", R.drawable.home_icon, NavBarRoutes.Home),
        NavItem("Stats", R.drawable.stats_icon, NavBarRoutes.Stats),
        NavItem("Profile", R.drawable.profile_icon, NavBarRoutes.Profile)
    )

    NavigationBar {

        navItems.forEach { item ->

            NavigationBarItem(
                selected = item.title == key,
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
                    selectedTextColor = Color.Blue,
                    selectedIconColor = Color.Blue,
                    indicatorColor = Color.Blue.copy(alpha = 0.1f),
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
package com.example.studyprogressxp.ui.navigation
//
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Notifications
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//
//@Composable
//fun MyNavBar() {
//
//    val navItems = listOf(
//        NavItem("Home", Icons.Default.Home),
//        NavItem("Search", Icons.Default.Search),
//        NavItem("Notifications", Icons.Default.Notifications),
//        NavItem("Profile", Icons.Default.Person)
//    )
//
//    NavigationBar {
//
//        navItems.forEach { item ->
//
//            NavigationBarItem(
//                selected = item.title == key,
//                onClick = {
//                    navController.navigate(item.routes){
////                        Its handling backStack
//                        popUpTo(navController.graph.startDestinationId){
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                },
//                icon = {
//                    Icon(
//                        imageVector =item.icon,
//                        contentDescription = "Home"
//                    )
//                },
//                label = { Text(text = item.title) },
////                alwaysShowLabel = false,
//                colors = NavigationBarItemDefaults.colors(
//                    selectedTextColor = Color.Blue,
//                    selectedIconColor = Color.Blue,
//                    indicatorColor = Color.Blue.copy(alpha = 0.1f),
//                    unselectedTextColor = Color.DarkGray,
//                    unselectedIconColor = Color.DarkGray
//                )
//            )
//        }
//
//    }
//}
//
//data class NavItem(
//    val title: String,
//    val icon: ImageVector,
//    val routes: NavBarRoutes
//)
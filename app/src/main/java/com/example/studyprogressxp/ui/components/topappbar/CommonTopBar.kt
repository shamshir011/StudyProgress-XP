package com.example.studyprogressxp.ui.components.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.Purple

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppTopBarUI(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Mindful Scholar",
            fontWeight = FontWeight.SemiBold
        )
        },

        actions = {
            IconButton(onClick = {
                navController.navigate(NavBarRoutes.Settings){
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Setting",
                    tint = Color.DarkGray
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = ElectricPurple,
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.White

        )
    )
}
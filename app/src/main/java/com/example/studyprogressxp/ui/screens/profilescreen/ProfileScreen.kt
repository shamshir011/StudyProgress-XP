package com.example.studyprogressxp.ui.screens.profilescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.MyNavBar

@Composable
fun ProfileScreen(navController: NavHostController){

    Scaffold(
        bottomBar = {MyNavBar(navController, "Profile")}
    ) { innerPadding->

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Profile Screen",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
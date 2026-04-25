package com.example.studyprogressxp.ui.components.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.studyprogressxp.ui.theme.ElectricPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpecificSkillTopBar(navController: NavController) {

    TopAppBar(
        title = { Text(text = "DSA",
            fontWeight = FontWeight.SemiBold
        )
        },

        navigationIcon = {
            IconButton(onClick = {navController.navigateUp()}){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Menu",
                    tint = Color.Black
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
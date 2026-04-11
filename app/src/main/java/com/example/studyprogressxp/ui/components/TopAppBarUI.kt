package com.example.studyprogressxp.ui.components

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppTopBarUI() {
    TopAppBar(
        title = { Text(text = "Mindful Scholar",
            fontWeight = FontWeight.SemiBold
        )
        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Search",
                    tint = Color.DarkGray
//                    tint = Color.Black
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Purple,
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.White

        )
    )
}
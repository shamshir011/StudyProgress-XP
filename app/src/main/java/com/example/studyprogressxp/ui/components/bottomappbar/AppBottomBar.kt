package com.example.studyprogressxp.ui.components.bottomappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.Purple

@Composable
fun AppBottomBar(navController: NavController) {
    BottomAppBar(
        containerColor = Color.LightGray.copy(alpha = 0.2f),
        contentColor = Purple // Changed 'content' to 'contentColor'
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {},
                colors = IconButtonDefaults.iconButtonColors(

                ),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(onClick = {},
                colors = IconButtonDefaults.iconButtonColors(

                ),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.stats_icon),
                    contentDescription = "Stats",
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(onClick = {},
                colors = IconButtonDefaults.iconButtonColors(

                ),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
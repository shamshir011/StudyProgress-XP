package com.example.studyprogressxp.ui.screens.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.data.local.datastore.UserPreferences
import com.example.studyprogressxp.data.repository.UserRepository
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.BlushPink
import com.example.studyprogressxp.ui.theme.DarkerRed
import com.example.studyprogressxp.ui.theme.LightRed
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.viewmodel.UserViewModel
import com.example.studyprogressxp.ui.viewmodel.UserViewModelFactory


@Composable
fun SettingScreen(navController: NavController, viewModel: UserViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Account",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth().clickable {
                navController.navigate(NavBarRoutes.UserEntry)
            },
            shape = RoundedCornerShape(16.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = LowPurple,
                            shape = RoundedCornerShape(100.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit_icon),
                        contentDescription = "Edit Profile Name"
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Name",
                        )


                        Text(
                            text = if (viewModel.userName.isNotEmpty()) {
                                viewModel.userName
                            } else {
                                "Your Name"
                            },
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Icon(
                        painter = painterResource(R.drawable.keyboard_arrow_right),
                        contentDescription = "Edit Profile Name"
                    )
                }
            }
        }


//*********************************************     Support     ****************************************************************

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Support",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = BlushPink,
                    shape = RoundedCornerShape(24.dp)
                )
                .drawBehind {
                    drawRoundRect(
                        color = Color(0xFFE5B5BB),
                        style = Stroke(
                            width = 1.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(12f, 12f),
                                0f
                            )
                        ),
                        cornerRadius = CornerRadius(24f, 24f)
                    )
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 24.dp, bottom = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = LightRed,
                            shape = RoundedCornerShape(100.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.dangerous_icon),
                        contentDescription = "Edit Profile Name",
                        tint = Color(0xFF8E2F3C),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Danger Zone",
                        color = DarkerRed,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Once you delete your data, it cannot be recovered." +
                                "This includes all XP, streaks and focus session.",
                        color = Color.DarkGray
                    )


//*******************************   Reset Button    ***************************************

                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                        modifier = Modifier
                            .width(220.dp)
                            .height(50.dp)
                            .background(
                                color = DarkerRed,
                                shape = RoundedCornerShape(50.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.delete_forever_icon),
                                contentDescription = "Reset All Data",
                                tint = LightRed
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Reset All Data",
                                color = LightRed
                            )
                        }
                    }
                }
            }
        }
    }
}
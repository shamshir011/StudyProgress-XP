package com.example.studyprogressxp.ui.screens.homescreen


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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.model.Skill
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple


@Composable()
fun HomeScreen(navController: NavController) {

    val trackedSkill = listOf(
        Skill(id = 1, "DSA", "45h tracked", R.drawable.code_icon),
        Skill(id = 2, "Android", "32h tracked", R.drawable.android_icon),
        Skill(id = 3, "Aptitude", "12h tracked", R.drawable.functions_icon),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        item {
            Text(
                text = "Good Evening",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ready for your next deep focus session?",
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Card(
                    modifier = Modifier
                        .size(170.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = DarkOrange,
                        contentColor = Color.Black
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {

                            Spacer(modifier = Modifier.height(8.dp))
                            Icon(
                                painter = painterResource(R.drawable.day_streak_icon),
                                contentDescription = "Day Streak",
                                modifier = Modifier.size(40.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "7 Day",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Streak",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Keep fire burning!"
                            )
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .size(170.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {

                            Spacer(modifier = Modifier.height(8.dp))
                            Icon(
                                painter = painterResource(R.drawable.clock_icon),
                                contentDescription = "Day Streak",
                                tint = Color.DarkGray
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "2.5 hrs",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Study time today",
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            LevelUI()

            Spacer(modifier = Modifier.height(16.dp))
        }


        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tracked Skills",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(color = Purple.copy(alpha = 0.1f))
                        .drawBehind {
                            drawRoundRect(
                                color = Color.DarkGray,
                                style = Stroke(
                                    width = 2.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(
                                        floatArrayOf(9f, 9f),
                                        0f
                                    )
                                ),
                                cornerRadius = CornerRadius(50f, 50f)
                            )
                        }
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center,

                    ) {
                    Text(
                        text = "View Details",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }


        item {
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LowPurple,
                    contentColor = Color.Black
                )
            ) {
                trackedSkill.forEach { product ->
                    CardItem(product)
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(NavBarRoutes.Session)
                    },
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Purple,
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(

                        modifier = Modifier
                            .padding(6.dp)
                            .size(40.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(100.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(34.dp),
                            painter = painterResource(R.drawable.play_arrow_icon),
                            contentDescription = "Start Session",
                            tint = Purple
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Start Study Session",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(12.dp))
                    .clickable {}
                    .padding(12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.square_dot_icon),
                    contentDescription = "Last Session",
                    tint = Purple
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Last Session: ",
                    color = Color.Black
                )

                Text(
                    text = "Android Development",
                    color = Color.Black
                )
            }
        }
    }
}
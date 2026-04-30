package com.example.studyprogressxp.ui.screens.home


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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
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
import com.example.studyprogressxp.model.TrackedSkill
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple


@Composable()
fun HomeScreen(navController: NavController) {

    val dailyQuests = listOf(
        Skill(id = 1, "DSA", "2.5h/", R.drawable.code_icon, "+50 XP", "3hrs"),
        Skill(id = 2, "Android", "1.5h/", R.drawable.android_icon, "+50 XP", "3hrs"),
        Skill(id = 3, "Aptitude", "0.5h/", R.drawable.functions_icon, "+50 XP", "3hrs"),
    )

    val trackedSkill = listOf(
        TrackedSkill(id = 1, R.drawable.code_icon, "DSA", "Level 3", ". 48%"),
        TrackedSkill(id = 2, R.drawable.android_icon, "Android", "Level 4", ". 68%"),
        TrackedSkill(id = 3, R.drawable.functions_icon, "Aptitude", "Level 4", ". 93%"),
        TrackedSkill(id = 4, R.drawable.android_icon, "Web Development", "Level 2", ". 58%"),
        TrackedSkill(id = 5, R.drawable.functions_icon, "Database", "Level 5", ". 70%")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(
                    color = Color.White
                )
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
                CurrentStreak()
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
                        text = "DAILY QUESTS",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
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
                                            floatArrayOf(9f, 9f), 0f
                                        )
                                    ),
                                    cornerRadius = CornerRadius(50f, 50f)
                                )
                            }
                            .padding(horizontal = 16.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        Text(
                            text = "View All",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }

                items(dailyQuests) { product ->
                    CardItem(
                        skill = product,
                        onClick = {
                            navController.navigate(NavBarRoutes.Skills)
                        }
                    )
                }


            item {
                Text(
                    text = "TRACKED SKILLS",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow {
                    item {
                        trackedSkill.forEach { tracked ->
                            TrackSkillCard(tracked)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(NavBarRoutes.AddNewSkill) {
                                launchSingleTop = true
                            }
                        },
                        containerColor = ElectricPurple,
                        contentColor = Color.White,
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

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
                        containerColor = ElectricPurple,
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
                        .clickable {}
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.square_dot_icon),
                        contentDescription = "Last Session",
                        tint = ElectricPurple
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
}
package com.example.studyprogressxp.ui.screens.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.DarkPurple
import com.example.studyprogressxp.ui.theme.LowPurple

//@Preview(showBackground = true)
@Composable
fun ProfileScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp),
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF6A4FBF),
                                Color(0xFF9B8AE6)
                            )
                        )
                    ),
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = LowPurple,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .size(100.dp)
                            .border(
                                width = 2.dp,
                                color = LowPurple,
                                shape = RoundedCornerShape(100.dp)
                            ),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.pic),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )

                        Box(
                            modifier = Modifier
                                .size(26.dp)
                                .align(Alignment.BottomEnd)
                                .background(
                                    color = LowPurple,
                                    shape = RoundedCornerShape(100.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.edit_icon),
                                contentDescription = "Edit Profile Image",
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = "Md Shamshir Alam",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row {
                        Text(
                            text = "Lifelong Learner: ",
                            color = Color.White
                        )

                        Text(
                            text = "Level 3 Scholar",
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier.background(
                                color = LowPurple,
                                shape = RoundedCornerShape(50.dp)
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = DarkPurple,
                                            shape = CircleShape
                                        )
                                        .padding(2.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.star_icon),
                                        contentDescription = "XP",
                                        tint = Color.White
                                    )
                                }

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = "120 XP",
                                    fontWeight = FontWeight.Bold,
                                    color = DarkPurple
                                )
                            }
                        }


                        Box(
                            modifier = Modifier.background(
                                color = DarkOrange,
                                shape = RoundedCornerShape(50.dp)
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.size(28.dp),
                                    painter = painterResource(R.drawable.day_streak_icon),
                                    contentDescription = "Longest Streak"
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = "Longest Streak: 7",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Achievements",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))
        AchievementUI()


        Spacer(modifier = Modifier.height(16.dp))
        NextMilestoneUI()
    }
}
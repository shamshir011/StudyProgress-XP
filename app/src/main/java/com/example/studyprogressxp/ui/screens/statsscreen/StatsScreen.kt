package com.example.studyprogressxp.ui.screens.statsscreen

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.MyNavBar
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.ui.theme.Purple40

//@Preview(showBackground = true)
@Composable
fun StatsScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        item {
            Text(
                text = "Focus Flow",
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
                        .size(height = 140.dp, width = 150.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        contentColor = Color.White
                    ),
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
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start

                        ) {


                            IconButton(
                                onClick = {},
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(30.dp)
                                    .background(
                                        color = Color.White.copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )

                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.clock_icon),
                                    contentDescription = "Day Streak",
                                    modifier = Modifier.size(30.dp)
                                )
                            }


                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "18 hrs",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "this week",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }


                Card(
                    modifier = Modifier
                        .size(height = 140.dp, width = 150.dp),
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

                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .border(
                                        width = 4.dp,
                                        color = DarkOrange,
                                        shape = RoundedCornerShape(100.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "85"
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "85%",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "CONSISTENCY",
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }



        item {
            Spacer(modifier = Modifier.height(32.dp))
            WeeklyStatus()
        }

        item {

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text=  "Weekly Insights",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            WeeklyInsightsCard()
        }

        item {

            Spacer(modifier = Modifier.height(32.dp))
            DeepFocusUI()
        }
    }
}
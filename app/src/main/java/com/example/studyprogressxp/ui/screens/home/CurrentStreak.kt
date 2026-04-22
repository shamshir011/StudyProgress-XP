package com.example.studyprogressxp.ui.screens.home


import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.DarkPurple2
import com.example.studyprogressxp.ui.theme.PrimaryOrange

@Preview
@Composable
fun CurrentStreak() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(

            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFF1A1A2E),
                            0.5f to Color(0xFF3A0CA3),
                            1.0f to Color(0xFF7209B7)
                        )
                    ),
                    shape = RoundedCornerShape(32.dp)
                )
        ) {

            Column(
                modifier = Modifier
                    .padding(start = 8.dp, top = 24.dp, bottom = 24.dp)
            ) {
                Text(
                    text = "CURRENT STREAK",
                    color = Color.LightGray
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.day_streak_icon),
                        contentDescription = "Day Streak",
                        tint = DarkOrange,
                        modifier = Modifier.size(48.dp)
                    )

                    Text(
                        text = "7",
                        fontSize = 44.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryOrange
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Days",
                        fontSize = 44.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Text(
                    text = "Keep the fire burning!",
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier.background(
                            color = DarkPurple2,
                            shape = RoundedCornerShape(16.dp)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                8.dp
                            )
                        ) {
                            Text(
                                text = "120 XP",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Today's Earned",
                                color = Color.LightGray
                            )
                        }
                    }

                    Box(
                        modifier = Modifier.background(
                            color = DarkPurple2,
                            shape = RoundedCornerShape(16.dp)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                8.dp
                            )
                        ) {
                            Text(
                                text = "LEVEL 3",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Current Level",
                                color = Color.LightGray
                            )
                        }
                    }

                    Box(
                        modifier = Modifier.background(
                            color = DarkPurple2,
                            shape = RoundedCornerShape(16.dp)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                8.dp
                            )
                        ) {
                            Text(
                                text = "2.5hrs",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Today Studied",
                                color = Color.LightGray
                            )
                        }
                    }
                }
            }
        }
    }
}
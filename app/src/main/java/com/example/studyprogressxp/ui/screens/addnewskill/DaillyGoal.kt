package com.example.studyprogressxp.ui.screens.addnewskill

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.PrimaryOrange
import com.example.studyprogressxp.ui.theme.Purple80


@Composable
fun DailyGoal(onSelected: (String) -> Unit) {

    var selectedIndex by remember { mutableStateOf(-1) }

    LazyRow {
        item {

            val isSelected = selectedIndex == 0
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
                    .border(
                        width = 1.dp,
                        if (isSelected) ElectricPurple else ElectricPurple.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp),
                        ambientColor = ElectricPurple,
                        spotColor = ElectricPurple
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        selectedIndex = 0
                        onSelected("30m")
                    },
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "🌴",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "30m",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )

                        Text(
                            text = "Casual",
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(110.dp)
                            .background(
//                            color = Purple80,
                                color = if (isSelected) ElectricPurple else Purple80,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "+20 XP",
                                color = if (isSelected) Color.White else ElectricPurple
                            )

                            Text(
                                text = "/day",
                                color = if (isSelected) Color.White else ElectricPurple
                            )
                        }
                    }
                }
            }


//        Focused


            val isSelected1 = selectedIndex == 1
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
                    .border(
                        width = 1.dp,
                        color = if (isSelected1) ElectricPurple else ElectricPurple.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp),
                        ambientColor = ElectricPurple,
                        spotColor = ElectricPurple
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        selectedIndex = 1
                        onSelected("1h")
                    },
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.day_streak_icon),
                            contentDescription = null,
                            tint = PrimaryOrange,
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "1h",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )

                        Text(
                            text = "Focused",
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(110.dp)
                            .background(
                                color = if (isSelected1) ElectricPurple else Purple80,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "+50 XP",
                                color = if (isSelected1) Color.White else ElectricPurple
                            )

                            Text(
                                text = "/day",
                                color = if (isSelected1) Color.White else ElectricPurple
                            )
                        }
                    }
                }
            }


//        Intense

            val isSelected2 = selectedIndex == 2

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
                    .border(
                        width = 1.dp,
                        color = if (isSelected2) ElectricPurple else ElectricPurple.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp),
                        ambientColor = ElectricPurple,
                        spotColor = ElectricPurple
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable {
                        selectedIndex = 2
                        onSelected("2h")
                    },
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "⚡",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "2h",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )

                        Text(
                            text = "Intense",
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(110.dp)
                            .background(
                                color = if (isSelected2) ElectricPurple else Purple80,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "+100 XP",
                                color = if (isSelected2) Color.White else ElectricPurple
                            )

                            Text(
                                text = "/day",
                                color = if (isSelected2) Color.White else ElectricPurple
                            )
                        }
                    }
                }
            }
        }
    }
}


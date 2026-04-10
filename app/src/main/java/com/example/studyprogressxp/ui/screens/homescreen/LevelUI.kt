package com.example.studyprogressxp.ui.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.Green

@Preview
@Composable
fun LevelUI() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(12.dp),

            colors = CardDefaults.cardColors(
                contentColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF7B61C8),
                                Color(0xFF9B8AE6)
                            )
                        )
                    ),

            ) {

                Box(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                ){

                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column{
                            Text(
                                text = "LEVEL 3"
                            )

                            Text(
                                text = "120 XP",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Card(
                                modifier = Modifier
                                    .width(250.dp)
                                    .height(8.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Green
                                )
                            ) { }

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "30 XPto Level 4"
                            )
                        }

                        Column(
                            modifier = Modifier
                                .height(70.dp)
                                .width(50.dp)
                        ) {

                            Card(
                                modifier = Modifier.fillMaxSize(),
                                shape = RoundedCornerShape(8.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White.copy(alpha = 0.3f),
                                    contentColor = Color.White
                                )
                            ) {

                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.star_icon),
                                        contentDescription = "Star"
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Text(
                                        text = "PRO",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
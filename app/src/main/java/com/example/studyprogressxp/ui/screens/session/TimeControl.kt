package com.example.studyprogressxp.ui.screens.session

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkerRed
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.ui.theme.VeryLowPurple


@Composable
fun TimeControlUI(
    skillName: String,
    timeLeft: Int,
    isRunning: Boolean,
    onStartPause: () -> Unit,
    onReset: () -> Unit,
    onStop: () -> Unit
) {

    val hours = timeLeft / 3600
    val minutes = (timeLeft % 3600) / 60
    val seconds = timeLeft % 60



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = ElectricPurple.copy(alpha = 0.1f),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "CURRENT FOCUS",
                    color = Color.DarkGray
                )

                Box(
                    modifier = Modifier
                        .background(
                            color = VeryLowPurple,
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.book_icon),
                            contentDescription = "Session icon",
                            tint = Purple
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = if (isRunning) "ACTIVE" else "PAUSED",
                            color = ElectricPurple
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = skillName,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = String.format("%02d:%02d:%02d", hours, minutes, seconds),
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )


                Text(
                    text = "REMAINING FOCUS TIME",
                    color = Color.DarkGray
                )
            }


            Spacer(modifier = Modifier.height(42.dp))


//            time controller

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

//*********************************************     Reset Button   ****************************************

                Column {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .border(
                                width = 1.dp,
                                color = ElectricPurple.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            )

                            .clickable { onReset() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.time_reset_icon),
                            contentDescription = "Reset"
                        )
                    }
                }

                Spacer(modifier = Modifier.width(32.dp))


                //*********************************************     START   ****************************************

                Column {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(16.dp),
                                ambientColor = ElectricPurple,
                                spotColor = ElectricPurple
                            )
                            .border(
                                width = 1.dp,
                                color = ElectricPurple.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable { onStartPause() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(
                                if (isRunning) R.drawable.clock_pause_icon
                                else R.drawable.play_arrow_icon
                            ),
                            contentDescription = if (isRunning) "Pause Icon" else "Play Icon",
                            tint = ElectricPurple
                        )
                    }
                }

                Spacer(modifier = Modifier.width(32.dp))

                //*********************************************     STOP   ****************************************

                Column {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .border(
                                width = 1.dp,
                                color = ElectricPurple.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable { onStop() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.stop_icon),
                            contentDescription = "Stop Icon",
                            tint = DarkerRed
                        )
                    }
                }
            }
        }
    }
}
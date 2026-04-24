package com.example.studyprogressxp.ui.screens.session

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.CoralPink
import com.example.studyprogressxp.ui.theme.DarkerRed
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LightRed1
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.ui.theme.VeryLowPurple

@Preview
@Composable
fun TimeControlUI() {

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
                            text = "ACTIVE",
                            color = ElectricPurple
                        )
                    }
                }
            }




            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Data Structures & Algorithms",
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
                    modifier = Modifier,
                    text = "00:45:00",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp
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

//*********************************************     PAUSE   ****************************************

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
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.time_reset_icon),
                            contentDescription = "Play Icon"
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
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.play_arrow_icon),
                            contentDescription = "Play Icon",
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
                            ),
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
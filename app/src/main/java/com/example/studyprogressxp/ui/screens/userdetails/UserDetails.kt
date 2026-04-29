package com.example.studyprogressxp.ui.screens.userdetails

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LightPurple
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple40

@Preview
@Composable
fun UserDetails() {

    Column(
        modifier = Modifier.fillMaxSize().background(
            color = Color.White,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            Text(
                text = "Make It",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "yours",
                color = Color.Black,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text=  "Pick a photo and a name your study buddies will recognise",
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(24.dp))





//                Box(
//                    modifier = Modifier.size(150.dp).background(
//                        color = Color(0xFFDAD4FF),
//                        shape = RoundedCornerShape(100.dp)
//                    ).align(Alignment.CenterHorizontally)
//                        .drawBehind {
//                        drawRoundRect(
//                            color = LightPurple,
//                            style = Stroke(
//                                width = 2.dp.toPx(),
//                                pathEffect = PathEffect.dashPathEffect(
//                                    floatArrayOf(12f, 12f),
//                                    0f
//                                )
//                            ),
//                            cornerRadius = CornerRadius(100f, 100f)
//                        )
//                    },
//                    contentAlignment = Alignment.Center
//                ){
//
//                    Icon(
//                        painter = painterResource(R.drawable.profile_icons),
//                        contentDescription = "Profile Icon",
//                        tint = LightPurple,
//                        modifier = Modifier.size(42.dp)
//                    )
//                    Box(
//                        modifier = Modifier
//                            .size(26.dp)
//                            .align(Alignment.BottomEnd)
//                            .offset(x = 6.dp, y = 6.dp)
//                            .background(
//                                color = ElectricPurple,
//                                shape = RoundedCornerShape(100.dp)
//                            ),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.edit_square_icon),
//                            contentDescription = "Edit Profile Image",
//                            modifier = Modifier.padding(4.dp),
//                            tint = Color.White
//                        )
//                    }
//                }


            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(
                        color = Color(0xFFDAD4FF),
                        shape = CircleShape
                    )
                    .align(Alignment.CenterHorizontally)
                    .drawBehind {
                        drawRoundRect(
                            color = LightPurple,
                            style = Stroke(
                                width = 2.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(12f, 12f),
                                    0f
                                )
                            ),
                            cornerRadius = CornerRadius(100f, 100f)
                        )
                    },
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = painterResource(R.drawable.profile_icons),
                    contentDescription = "Profile Icon",
                    tint = LightPurple,
                    modifier = Modifier.size(42.dp)
                )

                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 13.dp, y = 13.dp) // 👈 THIS is the key
                        .background(
                            color = ElectricPurple,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit_square_icon),
                        contentDescription = "Edit Profile Image",
                        modifier = Modifier.padding(4.dp),
                        tint = Color.White
                    )
                }
            }
            }
        }
//    }
}





//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
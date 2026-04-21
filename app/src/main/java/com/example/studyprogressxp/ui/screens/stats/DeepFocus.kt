package com.example.studyprogressxp.ui.screens.stats

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkPurple
import com.example.studyprogressxp.ui.theme.Green

@Preview
@Composable
fun DeepFocusUI() {

    Box(
        modifier = Modifier
            .fillMaxWidth().height(150.dp)
            .background(
                color = DarkPurple,
                shape = RoundedCornerShape(24.dp)
            )
    ) {

        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "NEXT MILESTONE",
                    color = Color(0xFFB9AFCF)
                )

                Text(
                    text = "Deep Focus Master",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEAE6F5)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .height(8.dp)
                        .background(
                            color = Green,
                            shape = RoundedCornerShape(50.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .size(height = 70.dp, width = 50.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF6A5AA3),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(
                        color = Color(0xFF4B2D82),
                        shape = RoundedCornerShape(16.dp)
                        ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.award_star_icon),
                    contentDescription = "Award",
                    tint = Color.White,

                )
            }
        }
    }
}
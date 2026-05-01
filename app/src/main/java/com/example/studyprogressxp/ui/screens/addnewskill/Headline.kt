package com.example.studyprogressxp.ui.screens.addnewskill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.ui.theme.PrimaryOrange

@Preview
@Composable
fun HeadlineUI(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF3A0CA3),
                        Color(0xFF7209B7)
                    )
                )
            )
    ) {

        Box(
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Center)
                .offset(x = 40.dp)
                .clip(CircleShape)
                .background(
                    Color.White.copy(alpha = 0.15f)
                )
        )

        Column(
            modifier = Modifier.fillMaxHeight()
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Master a",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "New",
                color = PrimaryOrange,
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "Craft Today-",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "Every skill you add boosts your daily XP potential",
                color = Color.LightGray
            )
        }
    }
}
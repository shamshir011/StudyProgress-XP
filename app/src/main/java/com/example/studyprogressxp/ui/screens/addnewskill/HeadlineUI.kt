package com.example.studyprogressxp.ui.screens.addnewskill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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

@Preview
@Composable
fun HeadlineUI(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF5B4BBA), // dark purple
                        Color(0xFF8A6FE8)  // light purple
                    )
                )
            )
    ) {

        // 🔵 Soft circle overlay
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

        // ✨ Text content
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 20.dp, end = 80.dp)
        ) {
            Text(
                text = "Master a New",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Craft Today.",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
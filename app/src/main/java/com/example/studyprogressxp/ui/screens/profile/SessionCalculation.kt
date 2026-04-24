package com.example.studyprogressxp.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LightGreen
import com.example.studyprogressxp.ui.theme.PrimaryOrange

@Preview
@Composable
fun SessionCalculation() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier.width(120.dp).height(70.dp)
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
                ).background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "45.5h",
                    fontSize = 22.sp,
                    color = ElectricPurple,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Total Focus",
                    color = Color.DarkGray
                )
            }
        }

        Box(
            modifier = Modifier.width(120.dp).height(70.dp)
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
                ).background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "820",
                    fontSize = 22.sp,
                    color = PrimaryOrange,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Total XP",
                    color = Color.DarkGray
                )
            }
        }




        Box(
            modifier = Modifier.width(120.dp).height(70.dp)
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
                ).background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "4",
                    fontSize = 22.sp,
                    color = LightGreen,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Skills",
                    color = Color.DarkGray
                )
            }
        }
    }
}
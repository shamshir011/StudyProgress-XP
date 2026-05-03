package com.example.studyprogressxp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.BlushPink
import com.example.studyprogressxp.ui.theme.ElectricPurple


@Composable
fun EmptySkill(NavController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth().height(250.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            )
            .drawBehind {
                drawRoundRect(
                    color = ElectricPurple.copy(alpha = 0.1f),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(12f, 12f),
                            0f
                        )
                    ),
                    cornerRadius = CornerRadius(24f, 24f)
                )
            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(150.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = ElectricPurple,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable{
                    NavController.navigate(NavBarRoutes.AddNewSkill)
                },
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Add Skill+",
                fontSize = 18.sp,
                color = ElectricPurple
            )
        }
    }
}
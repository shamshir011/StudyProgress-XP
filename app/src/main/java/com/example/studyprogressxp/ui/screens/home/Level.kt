package com.example.studyprogressxp.ui.screens.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.Green
import com.example.studyprogressxp.ui.theme.PrimaryOrange
import com.example.studyprogressxp.utils.getRequiredXpForLevel

@Composable
fun LevelUI(
    totalXp: Int,
    level: Int,
    levelTitle: String
) {
    val currentLevelStartXp = getRequiredXpForLevel(level)
    val nextLevelXpValue = getRequiredXpForLevel(level + 1)

    val levelXp = totalXp - currentLevelStartXp
    val xpNeededForThisLevel = nextLevelXpValue - currentLevelStartXp

    val progress = (levelXp.toFloat() / xpNeededForThisLevel.toFloat())
        .coerceIn(0f, 1f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(16.dp),
                    ambientColor = ElectricPurple,
                    spotColor = ElectricPurple
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.flash_icon),
                        contentDescription = "Level up",
                        tint = DarkOrange
                    )

                    Text(
                        text = "Level $level ",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryOrange
                    )

                    Text(
                        text = "- $levelTitle",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryOrange
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "$levelXp/$xpNeededForThisLevel XP",
                        color = Color.LightGray
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .background(
                            color = Color.LightGray.copy(alpha = 0.4f),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .height(10.dp)
                            .background(
                                color = PrimaryOrange,
                                shape = RoundedCornerShape(50.dp)
                            )
                    )
                }
            }
        }
    }
}
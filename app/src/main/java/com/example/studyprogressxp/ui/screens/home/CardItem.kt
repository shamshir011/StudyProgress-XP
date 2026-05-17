package com.example.studyprogressxp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.studyprogressxp.data.local.entity.SkillEntity
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.PrimaryOrange
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.utils.formatMinutes
import com.example.studyprogressxp.utils.goalToMinutes


@Composable
fun CardItem(
    skill: SkillEntity, onClick: () -> Unit

) {

    val goalMinutes = goalToMinutes(skill.goal)
    val goalSeconds = goalMinutes * 60

    val timeLeft = if (skill.timeLeftSeconds > 0) {
        skill.timeLeftSeconds
    } else {
        goalSeconds
    }

    val elapsedSeconds = (goalSeconds - timeLeft).coerceAtLeast(0)

    val remainingMinutes = timeLeft / 60

    val progress = (elapsedSeconds.toFloat() / goalSeconds.toFloat())
        .coerceIn(0f, 1f)



    Box(
        modifier = Modifier
            .height(100.dp)
            .padding(6.dp)
            .border(
                width = 1.dp,
                color = ElectricPurple.copy(alpha = 0.1f),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            )
            {
                AsyncImage(
                    model = skill.imagePath,
                    contentDescription = "Skill Icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column() {
                        Text(
                            text = skill.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row {
                            Text(
                                text = "${formatMinutes(remainingMinutes)}/",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = formatMinutes(goalMinutes),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Text(
                        text = "+${skill.goalXp} XP",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryOrange
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .background(
                            color = ElectricPurple.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .height(6.dp)
                            .background(
                                color = ElectricPurple,
                                shape = RoundedCornerShape(50.dp)
                            )
                    )
                }
            }
        }
    }
}
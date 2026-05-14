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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.studyprogressxp.data.local.entity.SkillEntity
import com.example.studyprogressxp.model.TrackedSkill
import com.example.studyprogressxp.ui.screens.session.SessionUiState
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.utils.getLevelFromXp
import com.example.studyprogressxp.utils.goalToMinutes


@Composable
fun TrackSkillCard(
    skill: SkillEntity,
    uiState: SessionUiState
) {

//    val goalMinutes = goalToMinutes(skill.goal)
//
//    val liveStudiedMinutes =
//        if (uiState.skillId == skill.id) {
//            uiState.studiedMinutes
//        } else {
//            skill.studiedMinutes
//        }
//
//    val studiedMinutes = liveStudiedMinutes.coerceIn(0, goalMinutes)
//
//    val progress =
//        if (uiState.skillId == skill.id) {
//            uiState.progress
//        } else {
//            (studiedMinutes.toFloat() / goalMinutes.toFloat())
//                .coerceIn(0f, 1f)
//        }
//
//    val percentage = (progress * 100).toInt()



//    New Added
    val goalSeconds = goalToMinutes(skill.goal) * 60

    val timeLeft = if (skill.timeLeftSeconds > 0) {
        skill.timeLeftSeconds
    } else {
        goalSeconds
    }

    val elapsedSeconds = (goalSeconds - timeLeft).coerceAtLeast(0)

    val progress = (elapsedSeconds.toFloat() / goalSeconds.toFloat())
        .coerceIn(0f, 1f)

    val percentage = (progress * 100).toInt()

    val skillLevel = getLevelFromXp(skill.xp)




//    val skillLevel = getLevelFromXp(skill.xp)

    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(200.dp)
            .border(
                width = 1.dp,
                color = ElectricPurple.copy(alpha = 0.1f),
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                ambientColor = ElectricPurple,
                spotColor = ElectricPurple
            )
            .background(Color.White, RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = skill.imagePath,
                    contentDescription = skill.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = skill.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Level $skillLevel. ",
                    color = Color.DarkGray
                )

                Text(
                    text = "$percentage%",
                    color = Color.DarkGray
                )
            }

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




//    val goalMinutes = goalToMinutes(skill.goal)
//
//    val liveStudiedMinutes =
//        if (uiState.skillId == skill.id) {
//            uiState.studiedMinutes
//        } else {
//            skill.studiedMinutes
//        }
//
//    val studiedMinutes = liveStudiedMinutes.coerceIn(0, goalMinutes)
//
//    val progress = (studiedMinutes.toFloat() / goalMinutes.toFloat())
//        .coerceIn(0f, 1f)
//
//    val percentage = (progress * 100).toInt()
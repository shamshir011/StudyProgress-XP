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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.model.TrackedSkill
import com.example.studyprogressxp.ui.theme.ElectricPurple


@Composable
fun TrackSkillCard(trackedSkill: TrackedSkill) {

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
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(trackedSkill.image),
                        contentDescription = "DSA",
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = trackedSkill.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = trackedSkill.level,
                    color = Color.DarkGray
                )

                Text(
                    text = trackedSkill.percentage,
                    color = Color.DarkGray
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .background(
                        color = ElectricPurple,
                        shape = RoundedCornerShape(50.dp)
                    )
            )
        }
    }
}
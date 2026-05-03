package com.example.studyprogressxp.ui.screens.session

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkGreen
import com.example.studyprogressxp.ui.theme.DarkOrange
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.PrimaryOrange
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.ui.viewmodel.SkillViewModel


@Composable
fun SessionScreen(
    navController: NavController,
    skillId: Int,
    viewModel: SkillViewModel
) {

    val skill by viewModel.getSkillById(skillId)
        .collectAsState(initial = null)




    skill?.let { data ->

        val goalText = data.goal // "2h", "1h", etc.

        val goalMinutes = when (goalText) {
            "30m" -> 30
            "1h" -> 60
            "2h" -> 120
            else -> 60
        }

        val studiedMinutes = data.xp / 10   // example logic

        val progress = (studiedMinutes.toFloat() / goalMinutes).coerceIn(0f, 1f)
        val percent = (progress * 100).toInt()



        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TimeControlUI(
                    onSessionComplete = {
                        viewModel.updateXp(data.id, 30)
                    }
                )


//            Spacer(modifier = Modifier.weight(1f))
//            ExpTarget()

                Spacer(modifier = Modifier.height(42.dp))


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .border(
                            width = 1.dp,
                            color = ElectricPurple.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.flash_icon),
                            contentDescription = "Earn XP",
                            tint = DarkOrange,
                            modifier = Modifier.size(40.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column() {
                                Text(
                                    text = "30 XP",
                                    fontWeight = FontWeight.Bold,
                                    color = ElectricPurple,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = "Earned this session",
                                    color = Color.DarkGray
                                )
                            }

                            Column() {
                                Text(
                                    text = "${data.streakDays}",
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryOrange,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = "Day Streak",
                                    color = Color.DarkGray
                                )
                            }
                        }
                    }
                }


                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = ElectricPurple.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(16.dp)
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


                                Text(
                                    text = "Daily Goal Progress",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Row {
                                    Text(
                                        text = "$percent%",
                                        color = DarkGreen,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(progress)
                                    .height(10.dp)
                                    .background(
                                        color = DarkGreen,
                                        shape = RoundedCornerShape(50.dp)
                                    )
                            )

                            Row() {
                                Text(
                                    text = "${studiedMinutes} min studied. ",
                                    color = Color.DarkGray
                                )

                                Text(
                                    text = "Goal: ${data.goal}",
                                    color = Color.DarkGray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
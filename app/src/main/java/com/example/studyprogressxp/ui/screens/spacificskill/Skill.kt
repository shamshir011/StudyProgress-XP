package com.example.studyprogressxp.ui.screens.spacificskill

import android.R.attr.data
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.viewmodel.SkillViewModel


@Composable
fun Skill(
    navController: NavController,
    skillId: Int,
    viewModel: SkillViewModel
) {

    val skill by viewModel.getSkillById(skillId)
        .collectAsState(initial = null)


    if (skill == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = ElectricPurple.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF3A0CA3),
                                Color(0xFF7209B7)
                            )
                        ),
                        shape = RoundedCornerShape(24.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 24.dp, bottom = 24.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = Color(0xFF10106E),
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.settings_icon),
//                                contentDescription = "Setting Icon",
//                                tint = Color.White,
//                                modifier = Modifier.size(32.dp)
//                            )

                            AsyncImage(
                                model = skill!!.imagePath,
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = skill!!.name,
                                fontSize = 22.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Level ${skill!!.level}",
                                color = Color.LightGray,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }


                    Spacer(modifier = Modifier.height(24.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
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
                                    text = "Goal: ${skill!!.goal}",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Row {
                                    Text(
                                        text ="${skill!!.xp} XP",
                                        color = Color.White
                                    )

//                                    Text(
//                                        "1200 XP",
//                                        color = Color.White
//                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(10.dp)
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(50.dp)
                                    )
                            )

                            Row() {
                                Text(
                                    text = "380 XP more to reach",
                                    color = Color.LightGray
                                )

                                Text(
                                    text = "Level 5",
                                    color = Color.LightGray
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TotalStudy()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "SUBJECT INFO",
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            SubjectInfo()

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE2C27B),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(
                        color = Color(0xFFE9E2D3),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Next: Graph Master - +150 XP",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFA06A00)
                    )

                    Text(
                        text = "Study 5 more sessions to unlock reward",
                        color = Color(0xFFB88A3C)
                    )
                }
            }


            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = ElectricPurple,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .clickable {
                        navController.navigate(NavBarRoutes.Session(skillId))
                    }

            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.play_arrow_icon),
                        contentDescription = "Play arrow icon",
                        tint = Color.White
                    )

                    Text(
                        text = "Start ${skill!!.name} Session",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
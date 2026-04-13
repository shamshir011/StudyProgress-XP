package com.example.studyprogressxp.ui.screens.statsscreen


import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.ui.theme.LowLightGray
import com.example.studyprogressxp.ui.theme.Purple40

@Preview(showBackground = true)
@Composable
fun WeeklyStatus() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = LowLightGray,
                shape = RoundedCornerShape(16.dp)
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Study Activity",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier.background(
                        color = Purple40,
                        shape = RoundedCornerShape(50.dp)
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Weekly",
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

//                Monday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Mon"
                    )
                }

//                Tuesday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Tue"
                    )
                }

//                Wednesday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Wed"
                    )
                }

//                Thursday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Thu"
                    )
                }

//                Friday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Fri"
                    )
                }

//                Saturday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sat"
                    )
                }

//                Sunday

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .width(40.dp)
                            .background(
                                color = Purple40,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {}

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sun"
                    )
                }
            }
        }
    }
}
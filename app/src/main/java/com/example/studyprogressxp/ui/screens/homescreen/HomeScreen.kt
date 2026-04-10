package com.example.studyprogressxp.ui.screens.homescreen

import android.widget.Space
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.MyNavBar
import com.example.studyprogressxp.ui.theme.DarkOrange

//@Preview(showBackground = true)
@Composable()
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = "Good Evening",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )


        Text(
            text = "Ready for your next deep focus session?",
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            
            Card(
                modifier = Modifier
                    .size(170.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = DarkOrange,
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                ){
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {

                        Spacer(modifier = Modifier.height(8.dp))
                        Icon(
                            painter = painterResource(R.drawable.day_streak_icon),
                            contentDescription = "Day Streak",
                            modifier = Modifier.size(40.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "7 Day",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Streak",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Keep fire burning!"
                        )
                    }
                }
            }


            Card(
                modifier = Modifier
                    .size(170.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                ){
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {

                        Spacer(modifier = Modifier.height(8.dp))
                        Icon(
                            painter = painterResource(R.drawable.clock_icon),
                            contentDescription = "Day Streak",
                            tint = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "2.5 hrs",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Study time today",
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LevelUI()
    }
}
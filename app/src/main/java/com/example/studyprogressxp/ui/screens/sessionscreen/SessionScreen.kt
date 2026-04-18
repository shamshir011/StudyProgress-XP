package com.example.studyprogressxp.ui.screens.sessionscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple


@Composable
fun SessionScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.width(200.dp).height(50.dp).background(
                color = LowPurple,
                shape = RoundedCornerShape(50.dp)
            )
        ){
            Row(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){

                Icon(
                    painter = painterResource(R.drawable.book_icon),
                    contentDescription = "Session icon",
                    tint = Purple
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "ACTIVE SESSION",
                    color = Purple
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Data Structures & Algorithms",
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(64.dp))

        Text(
            text = "00:45:00",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 64.sp
        )

        Text(
            text = "REMAINING FOCUS TIME",
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(44.dp))

        TimeControlUI()


        Spacer(modifier = Modifier.weight(1f))
        ExpTarget()
    }
}
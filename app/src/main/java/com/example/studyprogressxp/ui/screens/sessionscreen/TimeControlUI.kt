package com.example.studyprogressxp.ui.screens.sessionscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.CoralPink
import com.example.studyprogressxp.ui.theme.DarkerRed
import com.example.studyprogressxp.ui.theme.LightRed
import com.example.studyprogressxp.ui.theme.LightRed1
import com.example.studyprogressxp.ui.theme.Purple

@Preview
@Composable
fun TimeControlUI(){

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {


//*********************************************     PAUSE   ****************************************

        Column {
            Box(
                modifier = Modifier.size(50.dp).background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(100.dp)
                ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.pause_icon),
                    contentDescription = "Play Icon"
                )
            }

            Text(
                text = "PAUSE",
                color = Color.DarkGray
            )
        }


        //*********************************************     START   ****************************************

        Column {
            Box(
                modifier = Modifier.size(50.dp).background(
                    color = Purple,
                    shape = RoundedCornerShape(100.dp)
                ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.play_arrow_icon),
                    contentDescription = "Play Icon",
                    tint = Color.White
                )
            }

            Text(
                text = "START",
                color = Purple
            )
        }

        //*********************************************     STOP   ****************************************

        Column {
            Box(
                modifier = Modifier.size(50.dp).background(
                    color = CoralPink,
                    shape = RoundedCornerShape(100.dp)
                ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.stop_icon),
                    contentDescription = "Stop Icon",
                    tint = DarkerRed
                )
            }

            Text(
                text = "STOP",
                color = LightRed1
            )
        }
    }
}
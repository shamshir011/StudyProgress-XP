package com.example.studyprogressxp.ui.screens.addnewskill


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.ForestGreen
import com.example.studyprogressxp.ui.theme.Green
import com.example.studyprogressxp.ui.theme.LowPurple

@Preview
@Composable
fun FocusBoostUI() {

    Box(
        modifier = Modifier.fillMaxWidth().background(
            color = LowPurple,
            shape = RoundedCornerShape(24.dp)
        )
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Box(
                modifier = Modifier.size(70.dp).background(
                    color = Green,
                    shape = RoundedCornerShape(100.dp)
                ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    modifier = Modifier.size(44.dp),
                    painter = painterResource(R.drawable.mindfulness_icon),
                    contentDescription = "Focus Boost",
                    tint = ForestGreen
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column{
                Text(
                    text=  "Focus Boost",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text=  "Adding a new skill increases your daily streak potential",
                    color = Color.DarkGray
                )
            }
        }
    }
}
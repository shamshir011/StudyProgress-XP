package com.example.studyprogressxp.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyprogressxp.ui.theme.BurntOrange
import com.example.studyprogressxp.ui.theme.SoftBeige

@Preview
@Composable
fun NextMilestoneUI() {

    Box(
        modifier = Modifier.fillMaxWidth().height(150.dp).background(
            color = SoftBeige,
            shape = RoundedCornerShape(24.dp)
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "NEXT MILESTONE",
                color = BurntOrange,
                modifier = Modifier.align(Alignment.Start)
            )

            Text(
                buildAnnotatedString {
                    append("Reach 150 XP to unlock the ")

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ) {
                        append("Advanced Neural Mapping")
                    }
                    append(" course module")
                },
                color = Color.DarkGray
            )
        }

    }
}
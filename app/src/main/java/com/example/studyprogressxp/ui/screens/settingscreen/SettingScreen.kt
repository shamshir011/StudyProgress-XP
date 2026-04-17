package com.example.studyprogressxp.ui.screens.settingscreen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.DarkGreen
import com.example.studyprogressxp.ui.theme.DarkerRed
import com.example.studyprogressxp.ui.theme.LightRed
import com.example.studyprogressxp.ui.theme.LowPurple

//@Preview(showBackground = true)
@Composable
fun SettingScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        Text(
            text = "Account",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .background(
                            color = LowPurple,
                            shape = RoundedCornerShape(100.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit_icon),
                        contentDescription = "Edit Profile Name",
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Name",
                        )

                        Text(
                            text = "Md Shamshir Alam",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Icon(
                        painter = painterResource(R.drawable.keyboard_arrow_right),
                        contentDescription = "Edit Profile Name"
                    )
                }
            }
        }


        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Support",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(300.dp)
                .background(
                    color = LightRed,
                    shape = RoundedCornerShape(16.dp)
                ),
        ){
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.size(70.dp)
                        .background(
                            color = LightRed,
                            shape = RoundedCornerShape(100.dp)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(R.drawable.alert_icon),
                        contentDescription = "Edit Profile Name",
                        modifier = Modifier.size(32.dp)
                    )
                }

                Text(
                    text = "Danger Zone",
                    color = DarkerRed,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Once you delete your data, it cannot be recovered." +
                            "This includes all XP, streaks and focus session.",
                    color = Color.DarkGray
                )

                Box(
                    modifier = Modifier.width(250.dp).height(50.dp).background(
                        color = DarkerRed
                    ),
                    contentAlignment = Alignment.Center
                ){
                    Row(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.delete_forever_icon),
                            contentDescription = "Reset All Data",
                            tint = LightRed
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Reset All Data",
                            color = LightRed
                        )
                    }
                }
            }
        }
    }
}
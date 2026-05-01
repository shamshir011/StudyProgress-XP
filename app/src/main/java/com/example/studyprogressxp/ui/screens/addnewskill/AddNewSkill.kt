package com.example.studyprogressxp.ui.screens.addnewskill

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple
import java.io.File


@Composable
fun AddNewSkill() {

    Column(modifier = Modifier.fillMaxSize().background(
        color = Color.White
    )
    ){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        HeadlineUI()
        Spacer(modifier = Modifier.height(32.dp))


        Spacer(modifier = Modifier.height(8.dp))


        Box(
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(16.dp),
                    ambientColor = ElectricPurple,
                    spotColor = ElectricPurple
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(100.dp)
                )
                .size(100.dp)
//                .clickable {
//                    launcher.launch("image/*")
//                }
                .align(Alignment.CenterHorizontally),

            contentAlignment = Alignment.Center
        ) {

//            if (viewModel.imagePath.isNotEmpty()) {
//                Image(
//                    painter = rememberAsyncImagePainter(File(viewModel.imagePath)),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clip(CircleShape)
//                )
//            } else {
////                    Icon(Icons.Default.Person, contentDescription = null)
            Image(
                painter = painterResource(R.drawable.add_image_icon),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Add Skill cover Image",
            color = ElectricPurple,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

//    }


        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Add a new skill",
            color = Color.LightGray,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        var searchText by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = ElectricPurple.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(16.dp)
                ).background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text(text = "What will you learn next?", color = Color.Gray) },

                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        cursorColor = ElectricPurple,
                        focusedTextColor = Color.Black
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))








        Spacer(modifier = Modifier.height(24.dp))

//        FocusBoostUI()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "DAILY GOAL",
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(16.dp))

        DailyGoal()

        Spacer(modifier = Modifier.weight(1f))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50.dp),
            colors = CardDefaults.cardColors(
                containerColor = ElectricPurple
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Save Skill",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
}
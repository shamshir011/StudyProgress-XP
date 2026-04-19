package com.example.studyprogressxp.ui.screens.addnewskill

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.R
import com.example.studyprogressxp.ui.navigation.bottombarnavigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple

@Preview
@Composable
fun AddNewSkill() {

    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {

        HeadlineUI()
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Add a new skill",
            color = Color.LightGray,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(8.dp))

        var searchText by remember { mutableStateOf("") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            TextField(
                value = searchText,
                onValueChange = {searchText = it},
                placeholder ={Text(text = "What will you learn next?", color = Color.Gray)},

                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .height(58.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = LowPurple,
                    focusedContainerColor = LowPurple,
                    cursorColor = Color.LightGray,
                    focusedTextColor = Color.White
                )
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "POPULAR PATHWAYS",
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(){
            Box(
                modifier = Modifier.padding(8.dp).background(
                    color = LowPurple,
                    shape = RoundedCornerShape(50.dp)
                )
            ){
                Text(
                    modifier = Modifier.padding(start = 16.dp,end = 16.dp, top =8.dp, bottom = 8.dp),
                    text = "DSA",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier.padding(8.dp).background(
                    color = LowPurple,
                    shape = RoundedCornerShape(50.dp)
                )
            ){
                Text(
                    modifier = Modifier.padding(start = 16.dp,end = 16.dp, top =8.dp, bottom = 8.dp),
                    text = "Java",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier.padding(8.dp).background(
                    color = LowPurple,
                    shape = RoundedCornerShape(50.dp)
                )
            ){
                Text(
                    modifier = Modifier.padding(start = 16.dp,end = 16.dp, top =8.dp, bottom = 8.dp),
                    text = "Kotlin",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(){
            Box(
                modifier = Modifier.background(
                    color = LowPurple,
                    shape = RoundedCornerShape(50.dp)
                )
            ){
                Text(
                    modifier = Modifier.padding(start = 16.dp,end = 16.dp, top =8.dp, bottom = 8.dp),
                    text = "Aptitude",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier.padding(8.dp).background(
                    color = LowPurple,
                    shape = RoundedCornerShape(50.dp)
                )
            ){
                Text(
                    modifier = Modifier.padding(start = 16.dp,end = 16.dp, top =8.dp, bottom = 8.dp),
                    text = "Python",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier.padding(8.dp).background(
                    color = LowPurple,
                    shape = RoundedCornerShape(50.dp)
                )
            ){
                Text(
                    modifier = Modifier.padding(start = 16.dp,end = 16.dp, top =8.dp, bottom = 8.dp),
                    text = "UI Design",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        FocusBoostUI()

        Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Purple
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
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
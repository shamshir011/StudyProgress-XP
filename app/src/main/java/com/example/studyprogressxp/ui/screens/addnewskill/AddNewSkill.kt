package com.example.studyprogressxp.ui.screens.addnewskill

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprogressxp.ui.theme.LowPurple

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
    }
}
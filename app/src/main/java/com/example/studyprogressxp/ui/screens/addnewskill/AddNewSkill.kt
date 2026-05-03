package com.example.studyprogressxp.ui.screens.addnewskill

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
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
import com.example.studyprogressxp.ui.viewmodel.SkillViewModel
import com.example.studyprogressxp.utils.saveImageToInternalStorage
import java.io.File


@Composable
fun AddNewSkill(
    navController: NavController,
    skillViewModel: SkillViewModel
) {

    var savedImagePath by remember { mutableStateOf("") }
    var selectedGoal by remember { mutableStateOf("") }

    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val path = saveImageToInternalStorage(context, it)
            savedImagePath = path   // ✅ VERY IMPORTANT
        }
    }



    val xp = when (selectedGoal) {
        "30m" -> 20
        "1h" -> 50
        "2h" -> 100
        else -> 0
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {

            HeadlineUI()
            Spacer(modifier = Modifier.height(32.dp))


            Spacer(modifier = Modifier.height(8.dp))


            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(100.dp),
                        ambientColor = ElectricPurple,
                        spotColor = ElectricPurple
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(100.dp)
                    )
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                    launcher.launch("image/*")
                },

                contentAlignment = Alignment.Center
            ) {


                if (savedImagePath.isNotEmpty()) {
                    Image(
                        painter = rememberAsyncImagePainter(File(savedImagePath)),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize().clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.add_image_icon),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Add Skill cover Image",
                color = ElectricPurple,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )



            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Add a new skill",
                color = Color.Gray,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            var searchText by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = ElectricPurple.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {


                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    TextField(
                        modifier = Modifier.fillMaxSize(),
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = {
                            Text(
                                text = "What will you learn next?",
                                color = Color.Gray,
                                fontSize = 18.sp
                            )
                        },

                        shape = RoundedCornerShape(16.dp),
                        singleLine = true,

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


            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "DAILY GOAL",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            DailyGoal(onSelected = {
                selectedGoal = it
            })

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable{

                            val imagePath = savedImagePath   // from your picker
                            val goal = selectedGoal          // "30m", "1h", "2h"

                        if (searchText.isEmpty() || selectedGoal.isEmpty() || savedImagePath.isEmpty()) {
                            Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show()
                            return@clickable
                        }

//                        Convert goal → minutes HERE
                        val minutes = when (selectedGoal) {
                            "30m" -> 30
                            "1h" -> 60
                            "2h" -> 120
                            else -> 0
                        }

                        skillViewModel.addSkill(
                            name = searchText,
                            imagePath = savedImagePath,
                            goalMinutes = minutes,
                            xp = xp
                        ) {
                            Toast.makeText(context, "Skill added successfully", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }

                    },
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
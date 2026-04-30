package com.example.studyprogressxp.ui.screens.userentry

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.studyprogressxp.R
import com.example.studyprogressxp.data.local.datastore.UserPreferences
import com.example.studyprogressxp.data.repository.UserRepository
import com.example.studyprogressxp.ui.navigation.NavBarRoutes
import com.example.studyprogressxp.ui.theme.ElectricPurple
import com.example.studyprogressxp.ui.theme.LowPurple
import com.example.studyprogressxp.ui.theme.Purple
import com.example.studyprogressxp.ui.viewmodel.UserViewModel
import com.example.studyprogressxp.utils.saveImageToInternalStorage
import kotlinx.coroutines.launch
import java.io.File


@Composable
fun UserEntry() {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val prefs = UserPreferences(context)
    val repo = UserRepository(prefs)
    val viewModel = remember { UserViewModel(repo) }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    // Image Picker
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            selectedImageUri = it
            val path = saveImageToInternalStorage(context, it)
            viewModel.setImage(path)
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = "Make it",
                color = Color.Black,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "yours",
                    color = Color.Black,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    painter = painterResource(R.drawable.many_star_icon),
                    contentDescription = "Many Star",
                    modifier = Modifier.size(28.dp)
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFF8F7FF),
                        shape = RoundedCornerShape(100.dp)
                    )
                    .size(100.dp)
                    .clickable{
                        launcher.launch("image/*")
                    }
                    .align(Alignment.CenterHorizontally)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0xFFDAD4FF),
                            style = Stroke(
                                width = 2.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(12f, 12f),
                                    0f
                                )
                            ),
                            cornerRadius = CornerRadius(100f, 100f)
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
//                Image(
//                    painter = painterResource(R.drawable.person_icon),
//                    contentDescription = "Profile Image",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clip(CircleShape),
//                    contentScale = ContentScale.Fit
//                )
                if (viewModel.imagePath.isNotEmpty()) {
                    Image(
                        painter = rememberAsyncImagePainter(File(viewModel.imagePath)),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(Icons.Default.Person, contentDescription = null)
                }

                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .align(Alignment.BottomEnd)
                        .background(
                            color = ElectricPurple,
                            shape = RoundedCornerShape(100.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit_square_icon),
                        contentDescription = "Edit Profile Image",
                        modifier = Modifier.padding(4.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextField(
//                    value = searchText,
//                    onValueChange = {searchText = it},
                    value = viewModel.userName,
                    onValueChange = { viewModel.onNameChange(it) },
                    placeholder ={Text(text = "Enter your name", color = Color.Gray)},
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.profile_icons),
                            contentDescription = "Profile icon",
                            modifier = Modifier.size(32.dp),
                            tint = Color.DarkGray
                        )
                    },

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
                        cursorColor = Purple,
                        focusedTextColor = Color.Black
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier.width(220.dp).height(58.dp).align(Alignment.CenterHorizontally),
                onClick = {scope.launch {
                    viewModel.saveUser()
                }},
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ElectricPurple,
                    contentColor = Color.White
                ),
            ) {
                Text(
                    text = "Continue",
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painterResource(R.drawable.east_icon),
                    contentDescription = "East Icon",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


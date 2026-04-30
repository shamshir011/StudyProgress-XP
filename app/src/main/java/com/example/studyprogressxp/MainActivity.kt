package com.example.studyprogressxp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.studyprogressxp.ui.screens.userentry.UserEntry
import com.example.studyprogressxp.ui.theme.StudyProgressXPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyProgressXPTheme {


//                MainScreen()
                UserEntry()
            }
        }
    }
}


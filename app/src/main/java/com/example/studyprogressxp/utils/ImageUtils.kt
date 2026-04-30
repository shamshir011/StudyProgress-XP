package com.example.studyprogressxp.utils


import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

fun saveImageToInternalStorage(context: Context, uri: Uri): String {
    val file = File(context.filesDir, "profile.jpg")

    val input = context.contentResolver.openInputStream(uri)
    val output = FileOutputStream(file)

    input?.copyTo(output)

    return file.absolutePath
}
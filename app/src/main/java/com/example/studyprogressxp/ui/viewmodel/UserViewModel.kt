package com.example.studyprogressxp.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyprogressxp.data.repository.UserRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.first

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var isLoaded by mutableStateOf(false)

    var userName by mutableStateOf("")
    var imagePath by mutableStateOf("")

    fun onNameChange(name: String) {
        userName = name
    }

    fun setImage(path: String) {
        imagePath = path
    }

    fun saveUser() {
        viewModelScope.launch {
            repository.saveUser(userName, imagePath)
        }
    }


    fun loadUser() {
        viewModelScope.launch {
            userName = repository.getUserName().first()
            imagePath = repository.getImagePath().first()
            isLoaded = true
        }
    }
}
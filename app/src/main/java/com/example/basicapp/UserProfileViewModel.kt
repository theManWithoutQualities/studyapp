package com.example.basicapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class UserProfileViewModel(val savedStateHandle: SavedStateHandle) : ViewModel() {
    var user = UserRepository.getUser("1")
}
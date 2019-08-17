package com.example.basicapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class UserProfileViewModel(val savedStateHandle: SavedStateHandle) : ViewModel() {
    var user = MutableLiveData<User>(User("first user"))
}
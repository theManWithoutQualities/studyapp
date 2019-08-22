package com.example.basicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.Component
import dagger.Module
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(
    private val userRepository: UserRepository?
) : ViewModel() {

    fun get(): LiveData<User>? {
        return userRepository?.getUser("1")
    }
    constructor() : this(null)
}
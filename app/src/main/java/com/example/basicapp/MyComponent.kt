package com.example.basicapp

import dagger.Component

@Component(modules = [WebserviceModule::class])
interface MyComponent {

    fun injectViewModel(userProfileFragment: UserProfileFragment)
}
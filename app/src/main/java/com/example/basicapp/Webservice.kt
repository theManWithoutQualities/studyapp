package com.example.basicapp

import retrofit2.Call

interface Webservice {

    fun getUser(userId: String): Call<User>
}
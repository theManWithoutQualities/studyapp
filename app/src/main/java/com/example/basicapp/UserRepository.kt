package com.example.basicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    private val webservice: Webservice = TODO()

    fun getUser(userId: String): LiveData<User> {
        val data = MutableLiveData<User>()
        webservice.getUser(userId).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                data.value = response.body()
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO()
            }
        })
        return data
    }
}
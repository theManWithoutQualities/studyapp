package com.example.basicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Component
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class UserRepository @Inject constructor( private val webservice: Webservice) {

    private val cache = hashMapOf<String, LiveData<User>>("1" to MutableLiveData(User("user # 1")))

    fun getUser(userId: String): LiveData<User> {
        var data = cache.get(userId)
        if (data == null) {
            data = getUserFromNet(userId)
        }
        return data
    }

    private fun getUserFromNet(userId: String): LiveData<User> {
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
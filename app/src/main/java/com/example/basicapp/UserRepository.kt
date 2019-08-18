package com.example.basicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

object UserRepository {

    private val webservice: Webservice = Retrofit.Builder().baseUrl("http://url").build().create(Webservice::class.java)

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
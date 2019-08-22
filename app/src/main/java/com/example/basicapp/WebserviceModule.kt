package com.example.basicapp

import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.Retrofit

@Module
class WebserviceModule {

    @Provides
    fun getWebService(): Webservice {
        return Retrofit.Builder().baseUrl("http://url").build().create(Webservice::class.java)
    }
}

interface Webservice {

    fun getUser(userId: String): Call<User>
}
package com.example.basicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isAfterSavedInstanceState: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) isAfterSavedInstanceState = true
    }

    override fun onStart() {
        super.onStart()
        if (isAfterSavedInstanceState == true) return
        supportFragmentManager.beginTransaction().add(R.id.container, UserProfileFragment()).commit()
    }
}

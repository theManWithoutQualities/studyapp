package com.example.basicapp

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider


class UserProfileFragment : Fragment() {
    private var viewModel: UserProfileViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(activity?.application ?: throw Exception(), this)).get(UserProfileViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel?.user?.observe(viewLifecycleOwner, Observer<User> {
            activity?.findViewById<TextView>(R.id.user_info)?.text = it.info
        })
        Log.d("last timestamp", viewModel?.savedStateHandle?.get("lastVisitTimeStamp") ?: "start")
        viewModel?.savedStateHandle?.set("lastVisitTimeStamp", System.currentTimeMillis())
        Handler().postDelayed({ viewModel?.user?.value = User("new one") }, 5000)
    }
}

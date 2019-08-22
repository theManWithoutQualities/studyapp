package com.example.basicapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.internal.DaggerCollections
import javax.inject.Inject

class UserProfileFragment : Fragment() {
    @Inject lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(activity?.application ?: throw Exception(), this)).get(UserProfileViewModel::class.java)
        DaggerMyComponent.create().injectViewModel(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel?.get()?.observe(viewLifecycleOwner, Observer<User> {
            activity?.findViewById<TextView>(R.id.user_info)?.text = it.info
        })
//        Log.d("last timestamp", viewModel?.savedStateHandle?.get("lastVisitTimeStamp") ?: "start")
//        viewModel?.savedStateHandle?.set("lastVisitTimeStamp", System.currentTimeMillis().toString())
//        Handler().postDelayed({ viewModel?.user?.value = User("new one") }, 5000)
    }
}

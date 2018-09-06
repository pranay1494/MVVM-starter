package com.example.pranaybansal.mvvm_sample.ui.user

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.example.pranay.fabhotelsassignment.injection.ApplicationContext
import com.example.pranaybansal.mvvm_sample.data.DataManager
import com.example.pranaybansal.mvvm_sample.data.remote.model.BaseResponse
import com.example.pranaybansal.mvvm_sample.data.remote.model.User
import com.example.pranaybansal.mvvm_sample.injection.ActivityContext
import com.example.pranaybansal.mvvm_sample.ui.base.BaseViewModel
import javax.inject.Inject

class UserViewModel @Inject constructor(val dataManager: DataManager,val repository: UserRepository, application: Application) : BaseViewModel(application) {

    val welcomeMsg = MutableLiveData<String>()


    fun getWelcomeMsg(): LiveData<String> {
        dataManager.setWelcomeMessage("Welcome Pranay")
        val msg = dataManager.getWelcomeMessage()
        welcomeMsg.postValue(msg)
        return welcomeMsg
    }

    fun getUserData(name: String): LiveData<User> {
        val userdata = repository.fetchUserData(name = name)
        return userdata
    }

}
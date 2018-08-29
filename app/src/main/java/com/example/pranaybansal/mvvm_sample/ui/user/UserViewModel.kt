package com.example.pranaybansal.mvvm_sample.ui.user

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.pranaybansal.mvvm_sample.ui.base.BaseViewModel
import javax.inject.Inject

class UserViewModel @Inject constructor(val repository: UserRepository) : BaseViewModel() {

    val welcomeMsg = MutableLiveData<String>()

    fun getWelcomeMsg() : LiveData<String>{
        val msg = repository.getWelcomeMsg()
        welcomeMsg.postValue(msg)
        return welcomeMsg
    }

}
package com.example.pranaybansal.mvvm_sample.ui.user

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import com.example.pranaybansal.mvvm_sample.data.remote.model.BaseResponse
import com.example.pranaybansal.mvvm_sample.data.remote.model.User
import com.example.pranaybansal.mvvm_sample.ui.base.BaseViewModel
import javax.inject.Inject

class UserViewModel @Inject constructor(val repository: UserRepository) : BaseViewModel() {

    val welcomeMsg = MutableLiveData<String>()
    val fetchUserData = MutableLiveData<User>()

    fun getWelcomeMsg() : LiveData<String>{
        val msg = repository.getWelcomeMsg()
        welcomeMsg.postValue(msg)
        return welcomeMsg
    }

    fun getUserData(name: String) {
        val data = repository.fetchUserData(name = name)
        hideLoading()
        if (!TextUtils.isEmpty(data.errorMsg)){
            showErrorToastMsg(data.errorMsg)
        }else{
            fetchUserData.postValue(data.data)
        }
    }

}
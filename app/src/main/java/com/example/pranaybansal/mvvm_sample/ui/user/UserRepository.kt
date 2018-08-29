package com.example.pranaybansal.mvvm_sample.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.pranaybansal.mvvm_sample.data.remote.ApiService
import com.example.pranaybansal.mvvm_sample.data.remote.model.BaseResponse
import com.example.pranaybansal.mvvm_sample.data.remote.model.User
import com.example.pranaybansal.mvvm_sample.utils.DialogUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepository @Inject constructor(val apiService: ApiService) {

    fun getWelcomeMsg() : String{
        return "Welcome"
    }

    fun fetchUserData(name : String) : BaseResponse<User> {
        var response  = BaseResponse<User>()

        apiService.fetchUserInfo(username = name).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response.data =it
                },{
                    response.errorMsg = it.message?:"error"
                })
        return response
    }
}
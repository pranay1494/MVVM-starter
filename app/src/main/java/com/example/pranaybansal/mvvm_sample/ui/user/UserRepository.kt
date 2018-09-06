package com.example.pranaybansal.mvvm_sample.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.pranaybansal.mvvm_sample.data.remote.ApiService
import com.example.pranaybansal.mvvm_sample.data.remote.model.BaseResponse
import com.example.pranaybansal.mvvm_sample.data.remote.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepository @Inject constructor(val apiService: ApiService, val compositeDisposable: CompositeDisposable) {

    var response = MutableLiveData<User>()

    fun getWelcomeMsg(): String {
        return "Welcome"
    }

    fun fetchUserData(name: String): MutableLiveData<User> {

        compositeDisposable.add(apiService.fetchUserInfo(username = name).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response.value = it
                }, {
                }))

        return response
    }
}
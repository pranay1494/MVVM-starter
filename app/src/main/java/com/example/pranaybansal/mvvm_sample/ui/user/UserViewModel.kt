package com.example.pranaybansal.mvvm_sample.ui.user

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.util.Log
import com.example.pranaybansal.mvvm_sample.data.DataManager
import com.example.pranaybansal.mvvm_sample.data.remote.model.User
import com.example.pranaybansal.mvvm_sample.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UserViewModel @Inject constructor(val dataManager: DataManager,val repository: UserRepository, application: Application, compositeDisposable: CompositeDisposable) : BaseViewModel(application,compositeDisposable) {

    private val welcomeMsg = MutableLiveData<String>()
    private var userdata :LiveData<User>
    private var userdataChanged = MutableLiveData<String>()

    init {
        userdata = Transformations.switchMap(userdataChanged,{ name -> repository.fetchUserData(name)})
    }

    fun getWelcomeMsg() : LiveData<String>{
        return welcomeMsg
    }

    fun getUserData() : LiveData<User>{
        return userdata
    }

    fun setWelcomeMsg() {
        dataManager.setWelcomeMessage("Welcome Pranay")
        val msg = dataManager.getWelcomeMessage()
        welcomeMsg.postValue(msg)
    }

    fun getUserDataFromRepo(name: String) {
        userdataChanged.value = name
        //repository.fetchUserData(name)
        Log.d("composite_disposable",compositeDisposable.toString())
    }

}
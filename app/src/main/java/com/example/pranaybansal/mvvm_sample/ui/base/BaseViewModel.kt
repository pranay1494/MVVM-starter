package com.example.pranaybansal.mvvm_sample.ui.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.pranaybansal.mvvm_sample.MyApplication
import com.example.pranaybansal.mvvm_sample.utils.NetworkUtils

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val hideProgressDialog = MutableLiveData<Unit>()
    private val showErrorToast = MutableLiveData<String>()

     fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(getApplication<MyApplication>())
    }

    fun hideLoading(){
        hideProgressDialog.postValue(Unit)
    }
    fun showErrorToastMsg(msg :String){
        showErrorToast.postValue(msg)
    }

    override fun onCleared() {
        super.onCleared()
//        mCompositeDisposable.dispose()
    }

}
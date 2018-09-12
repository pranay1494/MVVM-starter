package com.example.pranaybansal.mvvm_sample.ui.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.pranaybansal.mvvm_sample.MyApplication
import com.example.pranaybansal.mvvm_sample.utils.NetworkUtils
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(application: Application, val compositeDisposable: CompositeDisposable) : AndroidViewModel(application) {

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
        Log.d("composite_disposable",compositeDisposable.toString())
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}
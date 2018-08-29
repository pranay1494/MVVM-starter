package com.example.pranaybansal.mvvm_sample.ui.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.pranaybansal.mvvm_sample.utils.NetworkUtils
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    private val mCompositeDisposable = CompositeDisposable()
    private val hideProgressDialog = MutableLiveData<Unit>()
    private val showErrorToast = MutableLiveData<String>()

//     fun isNetworkConnected(): Boolean {
//        return NetworkUtils.isNetworkConnected(getApplication())
//    }

    fun hideLoading(){
        hideProgressDialog.postValue(Unit)
    }
    fun showErrorToastMsg(msg :String){
        showErrorToast.postValue(msg)
    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
    }

}
package com.example.pranaybansal.mvvm_sample.ui.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import com.example.pranaybansal.mvvm_sample.utils.NetworkUtils
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    val mCompositeDisposable = CompositeDisposable()

//     fun isNetworkConnected(): Boolean {
//        return NetworkUtils.isNetworkConnected(getApplication())
//    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
    }

}
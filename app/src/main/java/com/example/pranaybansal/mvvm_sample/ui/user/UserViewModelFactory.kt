package com.example.pranaybansal.mvvm_sample.ui.user

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject


class UserViewModelFactory  : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return UserViewModel() as T
//        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
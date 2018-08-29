package com.example.pranaybansal.mvvm_sample.ui.user

import com.example.pranaybansal.mvvm_sample.data.remote.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(apiService: ApiService) {

    fun getWelcomeMsg() : String{
        return "Welcome"
    }
}
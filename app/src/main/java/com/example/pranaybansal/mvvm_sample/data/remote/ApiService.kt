package com.example.pranaybansal.mvvm_sample.data.remote

import com.example.pranaybansal.mvvm_sample.data.remote.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{user}")
    fun fetchUserInfo(@Path("user") username:String) : Single<User>
}
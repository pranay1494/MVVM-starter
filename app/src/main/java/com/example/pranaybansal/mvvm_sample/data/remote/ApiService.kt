package com.example.pranaybansal.mvvm_sample.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET
    fun login(username:String,password:String)
}
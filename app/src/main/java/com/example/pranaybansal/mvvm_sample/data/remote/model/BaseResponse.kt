package com.example.pranaybansal.mvvm_sample.data.remote.model

class BaseResponse<T> : ErrorResponse(){
    var data : T? = null

}
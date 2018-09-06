package com.example.pranaybansal.mvvm_sample.data.remote.model

open class BaseResponse<T> : ErrorResponse(){
    var data : T? = null

}
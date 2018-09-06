package com.example.pranaybansal.mvvm_sample.data.remote.model

open class ErrorResponse {
    var statusCode:Int = 0
    var errorMsg:String = ""
    var error:Throwable?=null
}
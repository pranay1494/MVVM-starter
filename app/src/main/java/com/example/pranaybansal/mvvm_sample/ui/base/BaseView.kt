package com.example.pranaybansal.mvvm_sample.ui.base

import android.support.annotation.StringRes

interface BaseView {
    fun showLoading(message: String)

    fun hideLoading()

    fun showToast(@StringRes resId: Int)

    fun showToast(message: String?)

    fun isNetworkConnected(): Boolean

    fun hideKeyboard()

    fun invalidAuthCode()
}
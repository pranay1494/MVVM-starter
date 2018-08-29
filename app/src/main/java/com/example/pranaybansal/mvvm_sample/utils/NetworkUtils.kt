package com.example.pranaybansal.mvvm_sample.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by @pranay on 27/12/17.
 */
object NetworkUtils{

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}
package com.example.pranaybansal.mvvm_sample.data.local

/**
 * Created by @pranay on 26/12/17.
 */
interface PreferenceManager {
    fun setWelcomeMessage(msg: String)
    fun getWelcomeMessage() : String?
}
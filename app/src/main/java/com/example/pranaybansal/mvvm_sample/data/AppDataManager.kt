package com.example.pranaybansal.mvvm_sample.data

import com.example.pranaybansal.mvvm_sample.data.local.PreferenceManager
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppDataManager @Inject constructor(val preferenceManager: PreferenceManager):DataManager {
    override fun setWelcomeMessage(msg: String) {
        preferenceManager.setWelcomeMessage(msg)
    }

    override fun getWelcomeMessage(): String? {
        return preferenceManager.getWelcomeMessage()
    }
}
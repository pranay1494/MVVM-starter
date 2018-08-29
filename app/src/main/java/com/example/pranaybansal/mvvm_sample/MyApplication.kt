package com.example.pranaybansal.mvvm_sample

import android.app.Application
import android.content.Context
import com.example.pranaybansal.mvvm_sample.injection.component.ApplicationComponent
import com.example.pranaybansal.mvvm_sample.injection.component.DaggerApplicationComponent
import com.example.pranaybansal.mvvm_sample.injection.module.AppModule
import com.example.pranaybansal.mvvm_sample.injection.module.NetworkModule
import com.example.pranaybansal.mvvm_sample.injection.module.ViewModelProviderModule

class MyApplication : Application(){

    private val mApplicationComponent : ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent.inject(this)
    }

    fun getApplictionComponent(): ApplicationComponent {
        return mApplicationComponent
    }

    companion object {
        fun get(context: Context) : MyApplication{
            return context.applicationContext as MyApplication
        }
    }


}

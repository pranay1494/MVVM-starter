package com.example.pranaybansal.mvvm_sample.injection.component

import com.example.pranaybansal.mvvm_sample.MyApplication
import com.example.pranaybansal.mvvm_sample.data.remote.ApiService
import com.example.pranaybansal.mvvm_sample.injection.module.AppModule
import com.example.pranaybansal.mvvm_sample.injection.module.NetworkModule
import com.example.pranaybansal.mvvm_sample.injection.module.ViewModelProviderModule
import com.example.pranaybansal.mvvm_sample.ui.user.UserActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class,AppModule::class))
interface ApplicationComponent {
    fun inject(application: MyApplication)

    fun provideApi() : ApiService;
}
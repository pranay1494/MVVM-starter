package com.example.pranaybansal.mvvm_sample.injection.module

import android.app.Application
import android.content.Context
import com.example.pranay.fabhotelsassignment.injection.ApplicationContext
import com.example.pranaybansal.mvvm_sample.MyApplication
import com.example.pranaybansal.mvvm_sample.injection.DatabaseInfo
import dagger.Module
import dagger.Provides

@Module
class AppModule(val application: MyApplication) {

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    internal fun provideApplication(): Application {
        return application
    }



}
package com.example.pranaybansal.mvvm_sample.injection.module

import android.app.Application
import android.content.Context
import com.example.pranaybansal.mvvm_sample.data.local.AppPreferenceManager
import com.example.pranaybansal.mvvm_sample.data.local.PreferenceManager
import com.example.pranay.fabhotelsassignment.injection.ApplicationContext
import com.example.pranaybansal.mvvm_sample.MyApplication
import com.example.pranaybansal.mvvm_sample.data.AppDataManager
import com.example.pranaybansal.mvvm_sample.data.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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

    @Singleton
    @Provides
    internal fun providePrefsManager(appPreferenceManager: AppPreferenceManager): PreferenceManager {
        return appPreferenceManager
    }

    @Singleton
    @Provides
    internal fun provideDataManager(dataManager: AppDataManager):DataManager{
        return dataManager
    }

}
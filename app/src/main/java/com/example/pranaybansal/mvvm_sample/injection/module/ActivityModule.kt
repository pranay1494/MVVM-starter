package com.example.pranaybansal.mvvm_sample.injection.module

import android.app.Activity
import android.content.Context
import com.bumptech.glide.Glide
import com.example.pranaybansal.mvvm_sample.injection.ActivityContext
import com.example.pranaybansal.mvvm_sample.injection.DatabaseInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

@Module
class ActivityModule(activity:Activity) {
    private var mActivity: Activity = activity

    @Provides
    @ActivityContext
    internal fun provideActivityContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }


    @Named("asd")
    @Provides
    fun provideName(): String {
        return "Pranay"
    }



}
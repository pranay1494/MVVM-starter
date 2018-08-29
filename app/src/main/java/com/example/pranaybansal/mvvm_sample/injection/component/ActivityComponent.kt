package com.example.pranaybansal.mvvm_sample.injection.component

import com.example.pranaybansal.mvvm_sample.injection.PerActivity
import com.example.pranaybansal.mvvm_sample.injection.module.ActivityModule
import com.example.pranaybansal.mvvm_sample.injection.module.ViewModelProviderModule
import com.example.pranaybansal.mvvm_sample.ui.base.BaseActivity
import com.example.pranaybansal.mvvm_sample.ui.user.UserActivity
import dagger.Component
import javax.inject.Named

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),modules = arrayOf(ActivityModule::class, ViewModelProviderModule::class))
interface ActivityComponent {
    fun inject(activity : UserActivity)

}
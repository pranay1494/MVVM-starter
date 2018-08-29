package com.example.pranaybansal.mvvm_sample.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.pranaybansal.mvvm_sample.ViewModelProviderFactory
import com.example.pranaybansal.mvvm_sample.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelProviderModule  {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun provideUserViewmodel(viewModel: UserViewModel):ViewModel

    @Binds
    abstract fun getViewmodelFactory(factory: ViewModelProviderFactory) : ViewModelProvider.Factory
}
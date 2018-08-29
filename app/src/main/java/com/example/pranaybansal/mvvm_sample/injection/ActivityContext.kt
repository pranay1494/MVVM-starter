package com.example.pranaybansal.mvvm_sample.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * Created by @pranay on 27/12/17.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityContext

package com.example.pranaybansal.mvvm_sample.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by @pranay on 27/12/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity
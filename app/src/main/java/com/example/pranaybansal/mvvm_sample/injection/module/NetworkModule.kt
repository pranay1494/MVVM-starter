package com.example.pranaybansal.mvvm_sample.injection.module

import android.util.Log
import com.example.pranaybansal.mvvm_sample.data.remote.ApiService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Module
class NetworkModule {

    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder().baseUrl("https://api.myjson.com/bins/bs67u/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    fun getLoggingInterceptor():HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor(object :  HttpLoggingInterceptor.Logger {
            override fun log(message: String?) {
                Log.d("api call: ",message)
            }

        })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }

    @Provides
    fun getOkHttpCient(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient()
                .newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
    }

    @Provides
    fun getApiClient(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
}
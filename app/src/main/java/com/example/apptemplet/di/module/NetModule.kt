package com.example.apptemplet.di.module

import com.example.apptemplet.core.Constants
import com.example.apptemplet.domain.WebApis
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(1,TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi{
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit.Builder{
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit.Builder): WebApis {
        return retrofit.baseUrl(Constants.NetworkService.BASE_URL)
            .build()
            .create(WebApis::class.java)
    }

}
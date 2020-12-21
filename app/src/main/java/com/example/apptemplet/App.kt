package com.example.apptemplet

import android.app.Application
import com.example.apptemplet.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App: Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//            Stetho.initializeWithDefaults(this)
        }

        AppInjector.init(this)
//        AndroidThreeTen.init(this)
    }
}
package com.example.apptemplet.di.module

import com.example.apptemplet.ui.main.MainActivity
import com.example.apptemplet.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}
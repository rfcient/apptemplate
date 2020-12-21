package com.example.apptemplet.di.module

import com.example.apptemplet.ui.dashboard.DashboardFragment
import com.example.apptemplet.ui.detail.UserDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment():DashboardFragment

    @ContributesAndroidInjector
    abstract fun contributeUserDetailFragment():UserDetailFragment
}
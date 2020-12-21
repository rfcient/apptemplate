package com.example.apptemplet.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apptemplet.di.ViewModelFactory
import com.example.apptemplet.di.key.ViewModelKey
import com.example.apptemplet.ui.dashboard.DashboardFragmentViewModel
import com.example.apptemplet.ui.detail.UserDetailViewModel
import com.example.apptemplet.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel):ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(DashboardFragmentViewModel::class)
    abstract fun provideDashboardFragmentViewModel(dashboardFragmentViewModel: DashboardFragmentViewModel):ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun provideUserDetailViewModel(userDetailViewModel: UserDetailViewModel):ViewModel

}
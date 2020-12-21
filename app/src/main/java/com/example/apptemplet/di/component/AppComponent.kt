package com.example.apptemplet.di.component

import android.app.Application
import com.example.apptemplet.App
import com.example.apptemplet.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetModule::class,
        ActivityModule::class,
        FragmentModule::class,
        DatabaseModule::class,
        ViewModelModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
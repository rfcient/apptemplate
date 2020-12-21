package com.example.apptemplet.di.module

import android.content.Context
import androidx.room.Room
import com.example.apptemplet.db.EmployeeDatabase
import com.example.apptemplet.db.dao.DataItemDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): EmployeeDatabase {
        return Room.databaseBuilder(
            context,
            EmployeeDatabase::class.java, "Employee-DB"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEmployeeDao(db:EmployeeDatabase):DataItemDao{
        return db.dataItemDao()
    }

}
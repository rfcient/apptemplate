package com.example.apptemplet.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apptemplet.db.dao.DataItemDao
import com.example.apptemplet.db.entity.DataItem

@Database(entities = [DataItem::class], version = 1, exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase(){
    abstract fun dataItemDao():DataItemDao
}
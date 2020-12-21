package com.example.apptemplet.db.dao

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.apptemplet.db.entity.DataItem


@Dao
interface DataItemDao {

    @Query("SELECT * FROM Employee")
    fun getEmployees():LiveData<List<DataItem>>

    @Query("SELECT * FROM Employee WHERE id = :id")
    fun getUserData(id:Int):LiveData<DataItem>

    @Insert(onConflict = REPLACE)
    fun insertEmployee(dataItem: DataItem)

    @Query("DELETE FROM Employee")
    fun deleteAllEmployees()

//    @Transaction
//    fun deleteAndInsertAll()

    @Delete
    suspend fun deleteEmployee(dataItem: DataItem)

    @Update
    fun updateEmployee(dataItem: DataItem):Int

    @Query("SELECT count(*) from Employee")
    fun getEmployeeCount():Int

}
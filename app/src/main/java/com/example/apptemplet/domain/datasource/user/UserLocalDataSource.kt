package com.example.apptemplet.domain.datasource.user

import androidx.lifecycle.LiveData
import com.example.apptemplet.db.dao.DataItemDao
import com.example.apptemplet.db.entity.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserLocalDataSource @Inject internal constructor(private val dao: DataItemDao){

    fun getUserList() = dao.getEmployees()

    fun insertUserList(dataItemList : List<DataItem>){
        dataItemList.forEach {
            dao.insertEmployee(it)
        }
    }

    fun getUserData(id:Int) = dao.getUserData(id)

    fun insertUserData(item: DataItem){
        dao.insertEmployee(item)
    }

    fun getItemCount() = dao.getEmployeeCount()

    suspend fun deleteRecord(dataItem: DataItem){
        dao.deleteEmployee(dataItem)
    }

    suspend fun updateRecord(dataItem: DataItem):Int{
        return withContext(Dispatchers.IO){
            dao.updateEmployee(dataItem)
        }
    }

    fun getUserDataSortedByName(): LiveData<List<DataItem>> {
        return dao.getEmployeesDataSortedByName()
    }
}
package com.example.apptemplet.domain.repo

import NetworkBoundResource
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.apptemplet.core.Constants.NetworkService.SYNC_STATUS
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.domain.datasource.user.UserLocalDataSource
import com.example.apptemplet.domain.datasource.user.UserRemoteDataSource
import com.example.apptemplet.domain.model.UserResponse
import com.example.apptemplet.ui.detail.UserDetailViewState
import com.example.apptemplet.utils.domain.Resource
import io.reactivex.Single
import javax.inject.Inject
import com.example.apptemplet.domain.model.UserDataResponse as UserDataResponse

class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val sharedPreferences: SharedPreferences
) {
    /*  fun loadUserData(page: Int): LiveData<Resource<UserResponse>> {
          return object : NetworkBoundResource<UserResponse, UserResponse>() {
              override fun createCall(): Single<UserResponse> =
                  userRemoteDataSource.getUserDataByPage(page)
          }.asLiveData
      }*/

    fun loadUserData(page: Int): LiveData<Resource<List<DataItem>>> {
        return object: NetworkBoundResource<List<DataItem>, UserResponse>(){
            override fun saveCallResult(item: UserResponse) {
                userLocalDataSource.insertUserList(item.userList as List<DataItem>)
                sharedPreferences.edit().putBoolean(SYNC_STATUS,true).commit()
            }

            override fun shouldFetch(data: List<DataItem>?): Boolean {
                return !sharedPreferences.getBoolean(SYNC_STATUS,false)
            }

            override fun loadFromDb(): LiveData<List<DataItem>> {
                return userLocalDataSource.getUserList()
            }

            override fun createCall(): Single<UserResponse> {
                return userRemoteDataSource.getUserDataByPage(page)
            }

            override fun onFetchFailed(errorMessage: String) {
                Log.d("error", errorMessage)
            }

        }.asLiveData
    }

    fun getUserDetails(userId: Int):LiveData<Resource<DataItem>>{

        return object : NetworkBoundResource<DataItem, UserDataResponse>(){
            override fun saveCallResult(response: UserDataResponse) {
                response.userData?.let { userLocalDataSource.insertUserData(it) }
            }

            override fun shouldFetch(data: DataItem?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<DataItem> {
                return userLocalDataSource.getUserData(userId)
            }

            override fun createCall(): Single<UserDataResponse> {
                return userRemoteDataSource.getUserDetailById(userId)
            }

            override fun onFetchFailed(errorMessage: String) {
                Log.d("User detail error: ", errorMessage);
            }

        }.asLiveData

//        return userRemoteDataSource.getUserDataByPage()
    }

    suspend fun deleteFromLocal(dataItem: DataItem) = userLocalDataSource.deleteRecord(dataItem)

    suspend fun updateRecord(dataItem: DataItem) = userLocalDataSource.updateRecord(dataItem)
}
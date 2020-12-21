package com.example.apptemplet.ui.dashboard

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.apptemplet.core.BaseViewModel
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.domain.repo.UserRepository
import com.example.apptemplet.utils.domain.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardFragmentViewModel @Inject internal constructor(private val userRepository: UserRepository, var sharedPreferences: SharedPreferences):BaseViewModel(){

    fun getUserDataViewState() = userDataViewState

    private val userDataViewState : LiveData<UserDataViewState> = userRepository.loadUserData(2).map {
        onCurrentWeatherResultReady(it)
    }

    private fun onCurrentWeatherResultReady(resource: Resource<List<DataItem>>): UserDataViewState {
//        isLoading.set(false)
        return UserDataViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    fun deleteRecord(dataItem: DataItem){
        viewModelScope.launch (Dispatchers.IO){
            userRepository.deleteFromLocal(dataItem)
        }
    }

    fun fetchUserSortByName(): LiveData<List<DataItem>> {
        return userRepository.loadUserDataSortByName()
    }
}
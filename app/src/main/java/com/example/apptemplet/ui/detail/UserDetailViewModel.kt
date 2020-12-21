package com.example.apptemplet.ui.detail

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.apptemplet.core.BaseFragment
import com.example.apptemplet.core.BaseView
import com.example.apptemplet.core.BaseViewModel
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.domain.model.UserDataResponse
import com.example.apptemplet.domain.repo.UserRepository
import com.example.apptemplet.ui.dashboard.UserDataViewState
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailViewModel @Inject internal constructor(private val userRepository: UserRepository,var sharedPreferences: SharedPreferences):
    BaseViewModel(){

        fun getUserDetailViewState(id:Int): LiveData<UserDetailViewState>{
            return userRepository.getUserDetails(id).map { it ->
                return@map UserDetailViewState(
                    status = it.status,
                    error = it.message,
                    data = it.data
                )
            }
        }

    fun updateUserDetails(item: DataItem){
        viewModelScope.launch{
           val result = userRepository.updateRecord(item)
           if(result>0)baseView.showMessage("Record Updated!") else baseView.showError("Update failed...")
        }
    }
}
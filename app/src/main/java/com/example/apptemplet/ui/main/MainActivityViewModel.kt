package com.example.apptemplet.ui.main

import android.content.SharedPreferences
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.apptemplet.core.BaseViewModel
import com.example.apptemplet.domain.model.UserResponse
import com.example.apptemplet.domain.repo.UserRepository
import com.example.apptemplet.domain.repo.UserRepository_Factory
import com.example.apptemplet.ui.dashboard.UserDataViewState
import com.example.apptemplet.utils.domain.Resource
import javax.inject.Inject

class MainActivityViewModel @Inject internal constructor(): BaseViewModel(){
    var toolbarTitle: ObservableField<String> = ObservableField()
}
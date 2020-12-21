package com.example.apptemplet.ui.dashboard.adapter

import androidx.databinding.ObservableField
import com.example.apptemplet.core.BaseViewModel
import com.example.apptemplet.db.entity.DataItem
import javax.inject.Inject

class UserItemViewModel @Inject internal constructor(): BaseViewModel(){
    var item = ObservableField<DataItem>()
}
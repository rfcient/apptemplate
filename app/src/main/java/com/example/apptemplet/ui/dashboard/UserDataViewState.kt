package com.example.apptemplet.ui.dashboard

import com.example.apptemplet.core.BaseViewState
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.utils.domain.Status

class UserDataViewState(
    val status: Status,
    val error: String? = null,
    val data: List<DataItem>?
) : BaseViewState(status, error) {
    fun getUserData() = data
}
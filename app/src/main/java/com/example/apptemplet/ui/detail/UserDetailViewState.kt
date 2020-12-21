package com.example.apptemplet.ui.detail

import com.example.apptemplet.core.BaseViewState
import com.example.apptemplet.db.entity.DataItem
import com.example.apptemplet.domain.model.UserDataResponse
import com.example.apptemplet.utils.domain.Status

class UserDetailViewState (
    val status: Status,
    val error: String? = null,
    val data: DataItem?
) : BaseViewState(status, error) {
    fun getUserData() = data
}
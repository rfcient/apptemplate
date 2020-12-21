package com.example.apptemplet.core

import com.example.apptemplet.utils.domain.Status


open class BaseViewState(val baseStatus: Status, val baseError: String?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}

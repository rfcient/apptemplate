package com.example.apptemplet.core

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message:String)
    fun showError(message: String)
}
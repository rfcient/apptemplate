package com.example.apptemplet.core

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel(){
    lateinit var baseView: BaseView
    var isLoading : ObservableBoolean = ObservableBoolean(false)

    public fun attachView(baseView: BaseView){
        this.baseView =baseView
    }
}

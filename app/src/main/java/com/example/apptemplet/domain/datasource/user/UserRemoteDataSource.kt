package com.example.apptemplet.domain.datasource.user

import com.example.apptemplet.domain.WebApis
import com.example.apptemplet.domain.model.UserDataResponse
import com.example.apptemplet.domain.model.UserResponse
import io.reactivex.Single
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val api:WebApis) {
    fun getUserDataByPage(page:Int):Single<UserResponse> = api.getUserData(page)

    fun getUserDetailById(id:Int):Single<UserDataResponse> = api.getUserDetail(id)
}
package com.example.apptemplet.domain

import com.example.apptemplet.domain.model.UserDataResponse
import com.example.apptemplet.domain.model.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebApis {

    @GET("users")
    fun getUserData(
        @Query("page")
        page:Int
    ):Single<UserResponse>

    @GET("users/{id}")
    fun getUserDetail(@Path("id") id: Int): Single<UserDataResponse>
}
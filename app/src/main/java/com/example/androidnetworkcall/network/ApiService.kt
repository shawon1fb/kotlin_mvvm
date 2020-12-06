package com.example.androidnetworkcall.network

import com.example.androidnetworkcall.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUsers(
        @Query("page") page: Int
    ): Call<UserModel>
}
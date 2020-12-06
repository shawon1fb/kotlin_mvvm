package com.example.androidnetworkcall.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androidnetworkcall.model.UserModel
import com.example.androidnetworkcall.network.ApiService
import com.example.androidnetworkcall.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    private var mResponse = MutableLiveData<UserModel>()

    fun fetchUsers(page: Int) {
        val retrofit = RetrofitClient.buildService(ApiService::class.java)
        val getUsers = retrofit.getUsers(page)
        getUsers.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.e("GSk", t.message!!)
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    Log.e("GSk", "Repo - Page $page")
                    Log.e("GSk", "Repo - Page ${response.body()?.data?.get(0)?.email}")
                    mResponse.postValue(response.body())
                }
            }
        })
    }


    fun observeResponse() = mResponse


}
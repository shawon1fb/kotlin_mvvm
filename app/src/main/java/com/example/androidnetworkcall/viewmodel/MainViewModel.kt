package com.example.androidnetworkcall.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidnetworkcall.model.UserModel
import com.example.androidnetworkcall.repositories.Repository

class MainViewModel : ViewModel() {
    var liveUserDara: MutableLiveData<UserModel>? = Repository.observeResponse()

    fun fetchUsers(page: Int) {
        Log.e("GSK", "VM - Page $page")
        Repository.fetchUsers(page)
    }


}
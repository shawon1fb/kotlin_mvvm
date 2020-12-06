package com.example.androidnetworkcall

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidnetworkcall.adepter.ImageAdepter
import com.example.androidnetworkcall.model.Datum
import com.example.androidnetworkcall.model.UserModel
import com.example.androidnetworkcall.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {


    var imageList: ArrayList<String> = arrayListOf(
        "https://raw.githubusercontent.com/shawon1fb/storeImage/master/squre/29-pixie-cut-with-highlights-and-bangs-BXaXhICgKs_.jpg",

        )


    var recyclerView: RecyclerView? = null

    private lateinit var viewModel: MainViewModel
    private var userList = mutableListOf<Datum>()
    private var page = 1
    private var totalPage = 1;
    var imageAdepter: ImageAdepter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.mainPageRecyclerView)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.fetchUsers(page)

        setUpRecyclerView()
        val nameObserver: Observer<UserModel> =
            Observer { newName -> // Update the UI, in this case, a TextView.
                Log.e("GSK", "onCreate: ${newName?.data?.size} ")
                newName?.data?.let { setAdepterData(it) }

            }

        viewModel.liveUserDara?.observe(this, nameObserver)

    }

    fun setAdepterData(newList: List<Datum?>) {
        imageAdepter?.setData(newList);
    }

    fun setUpRecyclerView() {
        imageAdepter = ImageAdepter(this, imageList)
        recyclerView?.adapter = imageAdepter
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    fun onResponseSuccessful(response: UserModel) {
        Log.e("GSK", "onResponseSuccessful")

        totalPage = response.totalPages!!
        //  adapter.setData(response.getData()!!)
    }


}



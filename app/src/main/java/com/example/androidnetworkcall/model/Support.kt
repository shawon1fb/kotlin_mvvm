package com.example.androidnetworkcall.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Support {
    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null
}
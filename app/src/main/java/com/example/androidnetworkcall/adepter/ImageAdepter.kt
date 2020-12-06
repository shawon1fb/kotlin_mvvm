package com.example.androidnetworkcall.adepter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidnetworkcall.R
import com.example.androidnetworkcall.model.Datum

@Suppress("UNREACHABLE_CODE")
class ImageAdepter(context: Context, images: ArrayList<String>?) :
    RecyclerView.Adapter<ImageAdepter.ImageHolder>() {

    var images: ArrayList<String>? = null

    lateinit var context: Context

    init {
        this.images = images
        this.context = context
    }


    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView? = null

        init {
            imageView = itemView.findViewById(R.id.RecyclerImageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        ///TODO("Not yet implemented")

        var layoutInflater: LayoutInflater = LayoutInflater.from(this.context)
        var view: View = layoutInflater.inflate(R.layout.image_layout, parent, false)
        return ImageHolder(view)


    }

    fun setData(newList: List<Datum?>) {
        for (index in newList.indices) {
            images?.add(newList[index]?.avatar!!)
        }
        Log.e("GSK", "Adapter Size : ${images?.size}")
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

        val options = RequestOptions()

        holder?.imageView?.let {
            Glide.with(context).load(images?.get(position)).apply(options).into(
                it
            )
        }
    }

    override fun getItemCount(): Int {


        return this.images!!.size

    }

}
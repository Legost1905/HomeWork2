package com.example.myapplication.ui.main

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.objects.Cat
import com.squareup.picasso.Picasso

class CatViewHolder(view: View): RecyclerView.ViewHolder(view) {
    protected val image by lazy{view.findViewById<ImageView>(R.id.image)}
    protected val imageLoader by lazy { Picasso.get() }

    fun bind(cat: Cat){
        val url="https://cataas.com/cat/${cat.imageId()}"
        imageLoader.load(url).into(image)
    }
}
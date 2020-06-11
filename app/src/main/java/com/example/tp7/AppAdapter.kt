package com.example.tp7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AppAdapter(var context: Context, var data:List<Movie>): RecyclerView.Adapter<AppViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): com.example.tp7.AppViewHolder {
        return AppViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        //holder.title.text = data[position].title
        //holder.year.text = data[position].year.toString()


    }






}









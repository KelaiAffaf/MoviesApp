package com.example.tp7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter(var context: Context, var data:List<Movie>): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): com.example.tp7.MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.title.text = data[position].name
        holder.year.text = data[position].year.toString()


    }






}









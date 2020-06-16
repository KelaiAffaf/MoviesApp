package com.example.tp7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
        holder.year.text = data[position].year
        holder.language.text=data[position].language



    }


    }

















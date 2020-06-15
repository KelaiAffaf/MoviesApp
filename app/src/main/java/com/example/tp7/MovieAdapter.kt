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
        holder.year.text = data[position].year.toString()



    }

    fun getmovie(namemovie: String) {
        val call = RetrofitService.instance.getMovie()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, "erreur", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) =
                if (response.isSuccessful) {
                    val list = response.body()
                    for (item in list!!) {
                        Toast.makeText(context, item.name, Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(context, "erreur2", Toast.LENGTH_LONG).show()
                }

        })
    }







}









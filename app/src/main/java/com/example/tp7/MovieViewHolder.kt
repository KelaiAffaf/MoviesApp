package com.example.tp7

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.add_movie_title) as TextView
    val year = view.findViewById<TextView>(R.id.text_view_year) as TextView
    val language= view.findViewById<TextView>(R.id.add_movie_lang)as TextView


}
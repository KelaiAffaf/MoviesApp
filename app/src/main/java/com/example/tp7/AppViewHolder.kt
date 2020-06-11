package com.example.tp7

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class AppViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.Text_view_titreMovie) as TextView
    val year = view.findViewById<TextView>(R.id.text_view_year) as TextView

}
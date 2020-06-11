package com.example.tp7

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ActorAdapter(var context: Context, var data:List<Actor>): RecyclerView.Adapter<ActorViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): com.example.tp7.ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        //holder.FirstName.text = data[position].Firstname
        //holder.LastName.text = data[position].lastName


    }






}









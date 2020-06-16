package com.example.tp7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ActorAdapter(var context: ListActivity, var data:List<Actor>): RecyclerView.Adapter<ActorViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): com.example.tp7.ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_actor, parent, false))
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.FirstName.text = data[position].firstname
        holder.LastName.text = data[position].lastname
        holder.gender.text=data[position].gender


    }







}









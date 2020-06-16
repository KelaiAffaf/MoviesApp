
package com.example.tp7

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ActorViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val FirstName = view.findViewById<TextView>(R.id.text_actor_fname) as TextView
    val LastName = view.findViewById<TextView>(R.id.text_actor_lname) as TextView
    val gender = view.findViewById<TextView>(R.id.text_actor_gender)as TextView



}
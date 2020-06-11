
package com.example.tp7

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ActorViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val FirstName = view.findViewById<TextView>(R.id.editText_name) as TextView
    val LastName = view.findViewById<TextView>(R.id.editText_Lname) as TextView

}
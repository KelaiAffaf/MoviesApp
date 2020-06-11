package com.example.tp7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        btn_movie.setOnClickListener {
            val intent = Intent( this, ListActivity::class.java)
            intent.putExtra("from", "movie")
            this.startActivity(intent)
        }
        btn_actor.setOnClickListener {
            val intent = Intent( this, ListActivity::class.java)
            intent.putExtra("from", "actor")
            this.startActivity(intent)
        }
    }


}

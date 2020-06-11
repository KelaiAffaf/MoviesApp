package com.example.tp7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var from = intent.getStringExtra("from")

        var recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            when(from){
                //"actor" -> adapter = AppAdapter(this@ListActivity,loadActors())
                "movie" -> adapter = AppAdapter(this@ListActivity,loadData())
            }
        }


        add_btn.setOnClickListener {
            val intent = Intent( this, movie_Form::class.java)
            intent.putExtra("from", from)
            this.startActivity(intent)
        }

    }

    fun loadData():List<Movie> {
        val data = mutableListOf<Movie>()
        data.add(Movie(1,"1","b","c"))
        data.add(Movie(2,"1","b","c"))
        data.add(Movie(3,"1","b","c"))
        data.add(Movie(4,"1","b","c"))


        return data
    }

}

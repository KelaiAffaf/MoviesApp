package com.example.tp7

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListActivity : AppCompatActivity() {
    var actorList = ArrayList<Actor>()
    var recyclerView:RecyclerView ?=null
    var from:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
      //  actorList=getActors()
        from = intent.getStringExtra("from")

         recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)

        }
        when (from) {
            "actor" -> getActors()
            "movie" -> getMovies()
        }
        add_btn.setOnClickListener {
            val intent = Intent( this, movie_Form::class.java)
            intent.putExtra("from", from)
            this.startActivity(intent)
        }

    }

    fun loadData():List<Movie> {
        val data = mutableListOf<Movie>()
        data.add(Movie("1","b","c"))
        data.add(Movie("1","b","c"))
        data.add(Movie("1","b","c"))
        data.add(Movie("1","b","c"))


        return data
    }


    fun getActors() {
        val call = RetrofitService.instance.getActor()
        var list=ArrayList<Actor>()
        call.enqueue(object : Callback<List<Actor>> {
            override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "erreur", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                if (response.isSuccessful) {
                    list = response.body()!! as ArrayList<Actor>
                    recyclerView?.apply {
                        adapter = ActorAdapter(this@ListActivity, list)
                    }


                } else {
                    Toast.makeText(this@ListActivity, "erreur2", Toast.LENGTH_LONG).show()
                    System.out.println("error message " + response.message())
                    System.out.println("error cause " + response.errorBody().toString())
                }

            }
        })


    }

    fun getMovies() {
        val call = RetrofitService.instance.getMovie()
        var listmovies=ArrayList<Movie>()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "erreur", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) {
                    listmovies = response.body()!! as ArrayList<Movie>

                    recyclerView?.apply {
                        adapter = MovieAdapter(this@ListActivity, listmovies)
                    }

                } else {
                    Toast.makeText(this@ListActivity, "erreur2", Toast.LENGTH_LONG).show()
                    System.out.println("error message " + response.message())
                    System.out.println("error cause " + response.errorBody().toString())
                }
            }

        })



    }





}

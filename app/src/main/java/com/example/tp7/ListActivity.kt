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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
      //  actorList=getActors()
        var from = intent.getStringExtra("from")
        actorList= getActors()
        System.out.println("actoreList"+actorList.toString())
        var recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            when (from) {
                "actor" -> adapter = ActorAdapter(this@ListActivity, actorList)
                "movie" -> adapter = AppAdapter(this@ListActivity, loadData())
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


    fun getActors():ArrayList<Actor> {
        val call = RetrofitService.instance.getActor()
        var list=ArrayList<Actor>()
        call.enqueue(object : Callback<List<Actor>> {
            override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "erreur", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) =
                if (response.isSuccessful) {
                    list = response.body()!! as ArrayList<Actor>
                 /*   for (item in list!!) {
                        Toast.makeText(this@ListActivity, item.firstname, Toast.LENGTH_LONG).show()
                    }*/System.out.println("Get Actors "+ list.toString())

                } else {
                    Toast.makeText(this@ListActivity, "erreur2", Toast.LENGTH_LONG).show()
                    System.out.println("error message "+ response.message())
                    System.out.println("error cause "+ response.errorBody().toString())
                }

        })

       return list

    }

    fun getMovies():ArrayList<Movie> {
        val call = RetrofitService.instance.getMovie()
        var listmovies=ArrayList<Movie>()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "erreur", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) =
                if (response.isSuccessful) {
                    listmovies = response.body()!! as ArrayList<Movie>
                    /*   for (item in list!!) {
                           Toast.makeText(this@ListActivity, item.firstname, Toast.LENGTH_LONG).show()
                       }*/System.out.println("Get Actors "+ list.toString())

                } else {
                    Toast.makeText(this@ListActivity, "erreur2", Toast.LENGTH_LONG).show()
                    System.out.println("error message "+ response.message())
                    System.out.println("error cause "+ response.errorBody().toString())
                }

        })

        return listmovies

    }



    inner class AsynTsk:AsyncTask<Int,Int,Void>(){

        override fun onPreExecute() {
            super.onPreExecute()
           // listener.onTaskCompleted();
        }

        override fun doInBackground(vararg params: Int?): Void {
            TODO("Not yet implemented")
        }
    }


}

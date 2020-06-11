package com.example.tp7


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class movie_Form : AppCompatActivity(), AddActorFragment.OnFragmentInteractionListener,
    AddMovieFragment.OnFragmentInteractionListener{

    private val fragmentManager = supportFragmentManager
    private val addActorFragment = AddActorFragment()
    private val addMovieFragment = AddMovieFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie__form)
        var from = intent.getStringExtra("from")
        System.out.println("I'm coming from: " + from)

        val fragmentTransaction = fragmentManager.beginTransaction()

        when(from){
            "actor" -> fragmentTransaction.replace(R.id.fragment_container, addActorFragment)
            "movie" -> fragmentTransaction.replace(R.id.fragment_container, addMovieFragment)
        }

        fragmentTransaction.commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

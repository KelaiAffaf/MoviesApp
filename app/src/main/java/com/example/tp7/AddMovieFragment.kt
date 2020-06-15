package com.example.tp7

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tp7.RetrofitService.retrofit
import kotlinx.android.synthetic.main.fragment_add_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddMovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var v =  inflater.inflate(R.layout.fragment_add_movie, container, false)
        var btnSave= v.findViewById<View>(R.id.save_btn) as Button
        btnSave.setOnClickListener {


                val title=add_movie_title.text.toString()
                val year=add_movie_year.text.toString()
                val lang =add_movie_lang.text.toString()

                if(title.isEmpty()){
                    add_movie_title.error="first_name is required"
                    add_movie_title.requestFocus()
                    return@setOnClickListener
                }

                if(year.isEmpty()){
                    add_movie_year.error="Last_name is required"
                    add_movie_year.requestFocus()
                    return@setOnClickListener
                }

                if(lang.isEmpty()){
                    add_movie_lang.error="gender is required"
                    add_movie_lang.requestFocus()
                    return@setOnClickListener
                }


                RetrofitService.instance.addActor(title,year,lang).enqueue(object :
                    Callback<Actor> {

                    override fun onResponse(call: Call<Actor>, response: Response<Actor>) {
                        if(response.isSuccessful){

                            Toast.makeText(this@AddMovieFragment.context,"Success", Toast.LENGTH_LONG).show()


                        }else{
                            Toast.makeText(this@AddMovieFragment.context,"Failure", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<Actor>, t: Throwable) {
                        Toast.makeText(this@AddMovieFragment.context,"Failure", Toast.LENGTH_LONG).show()
                    }
                })


            //////////////////////////////////////////////////////////////////////////////////////////

            val service = retrofit.create(Endpoint::class.java)
            val movieRequest = service.listMovie()
            movieRequest.enqueue(object : Callback<List<Movie>> {
                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    val allMovies = response.body()
                    if (allMovies != null) {
                        print("HERE is ALL Movies FROM Movies Database:")
                        for (m in allMovies)
                            print(" one course : ${m.id}: ${m.name} : ${m.year} : ${m.language}")
                    }
                }
                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    error("KO")
                }
            })



            val intent = Intent( this.context, ListActivity::class.java)
            intent.putExtra("from", "actor")
            this.startActivity(intent)
        }
        return v

    }


    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddMovieFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddMovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

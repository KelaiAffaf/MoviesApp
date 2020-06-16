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
import kotlinx.android.synthetic.main.activity_actor_form.*

import kotlinx.android.synthetic.main.fragment_add_actor.*
import kotlinx.android.synthetic.main.fragment_add_actor.save_btn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddActorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddActorFragment : Fragment() {
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
        var v =  inflater.inflate(R.layout.fragment_add_actor, container, false)
        var btnSave= v.findViewById<View>(R.id.save_btn) as Button
        btnSave.setOnClickListener {


            val first_name=add_actor_firstname.text.toString()
            val Last_name=add_actor_lastname.text.toString()
            val gender =add_actor_gender.text.toString()
            print(first_name+Last_name+ gender)

            if(first_name.isEmpty()){
                add_actor_firstname.error="first_name is required"
                add_actor_firstname.requestFocus()
                return@setOnClickListener
            }

            if(Last_name.isEmpty()){
                add_actor_lastname.error="Last_name is required"
                add_actor_lastname.requestFocus()
                return@setOnClickListener
            }

            if(gender.isEmpty()){
                add_actor_gender.error="gender is required"
                add_actor_gender.requestFocus()
                return@setOnClickListener
            }

            val actor = Actor(first_name,Last_name,gender)
            addactor(actor)

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


    fun addactor(actor1:Actor){

        println("la fonction add actor")

        RetrofitService.instance.addActor(actor1.firstname,actor1.lastname,actor1.gender).enqueue(object :
            Callback<Actor> {

            override fun onResponse(call: Call<Actor>, response: Response<Actor>) {
                if(response.isSuccessful){

                    Toast.makeText(this@AddActorFragment.context,"Success", Toast.LENGTH_LONG).show()


                }else{
                    Toast.makeText(this@AddActorFragment.context,"Failure", Toast.LENGTH_LONG).show()
                    System.out.println("error message "+ response.message())
                    System.out.println("error cause "+ response.errorBody().toString())

                }
            }

            override fun onFailure(call: Call<Actor>, t: Throwable) {
                Toast.makeText(this@AddActorFragment.context,t.message  , Toast.LENGTH_LONG).show()
                System.out.println("error message "+ t.message)
                System.out.println("error cause "+ t.cause.toString())
                System.out.println("error localize"+ t.localizedMessage)
            }
        })


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
         * @return A new instance of fragment AddActorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddActorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

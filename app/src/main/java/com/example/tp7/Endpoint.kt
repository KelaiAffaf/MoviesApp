package com.example.tp7


import retrofit2.Call
import retrofit2.http.*

interface Endpoint {

    @GET("getMovie")
    fun getMovie(): Call<List<Movie>>

    @FormUrlEncoded
    @POST("addActor")
    fun addActor(
        @Field("firstname") firstname:String,
        @Field("lastname") lastname:String,
        @Field("gender") gender:String
    ):Call<Actor>

    @FormUrlEncoded
    @POST("addMovie")
    fun addmovie(
        @Field("name") name:String,
        @Field("year") year:String,
        @Field("language") language:String
    ):Call<Movie>

    
    
    @POST("addmovie")
    fun addMovie(@Body movie: Movie):Call<String>
}
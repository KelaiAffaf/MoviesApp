package com.example.tp7
import android.util.Base64
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitService {


    //private val AUTH = "Basic "+ Base64.encodeToString("root:123456".toByteArray(), Base64.NO_WRAP)

    private const val BASE_URL = "https://3478955d8a89.ngrok.io"

    private val okHttpClient = OkHttpClient.Builder().build()

    val instance: Endpoint by lazy{

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Endpoint::class.java)
    }

    val retrofit = Retrofit.Builder()
        .baseUrl("https://3478955d8a89.ngrok.io")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }






}
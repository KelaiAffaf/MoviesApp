package com.example.tp7
import android.util.Base64
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService {


    private val AUTH = "Basic "+ Base64.encodeToString("belalkhan:123456".toByteArray(), Base64.NO_WRAP)

    private const val BASE_URL = "http://192.168.1.38:8082/"

    private val okHttpClient = OkHttpClient.Builder().build()

    val instance: Endpoint by lazy{
        print("hello Amel gatlk hello"+ okHttpClient.toString())
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Endpoint::class.java)
    }


}
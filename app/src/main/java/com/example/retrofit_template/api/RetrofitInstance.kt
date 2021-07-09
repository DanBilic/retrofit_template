package com.example.retrofit_template.api

import com.example.retrofit_template.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// object cuz RetrofitInstance is singleton
// object -> the kotlin way to create singletons
object RetrofitInstance {
    private val retroFit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: SimpleApi by lazy{
        retroFit.create(SimpleApi::class.java)
    }
}
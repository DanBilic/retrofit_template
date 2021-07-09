package com.example.retrofit_template.api

import com.example.retrofit_template.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("post/1")
    suspend fun getPost(): Response<Post>
}
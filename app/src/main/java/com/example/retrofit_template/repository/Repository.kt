package com.example.retrofit_template.repository

import com.example.retrofit_template.api.RetrofitInstance
import com.example.retrofit_template.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPosts(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}
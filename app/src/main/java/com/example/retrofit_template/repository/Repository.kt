package com.example.retrofit_template.repository

import com.example.retrofit_template.api.RetrofitInstance
import com.example.retrofit_template.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPosts(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPosts2(number: Int): Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts(userId)
    }
}
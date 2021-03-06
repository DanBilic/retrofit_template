package com.example.retrofit_template.api

import com.example.retrofit_template.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    // static header
    @Headers(
        "Authorization: 1234567",
        "Platform: Android"
        )
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    // dynamic header
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int,
        @Header("Auth") auth: String
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>
}
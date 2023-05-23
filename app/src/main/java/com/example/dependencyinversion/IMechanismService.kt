package com.example.dependencyinversion

import retrofit2.http.GET

interface IMechanismService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
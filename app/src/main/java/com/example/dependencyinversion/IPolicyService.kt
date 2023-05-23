package com.example.dependencyinversion

interface IPolicyService {
    suspend fun getPosts(): List<Post>
}
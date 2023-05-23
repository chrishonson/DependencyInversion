package com.example.dependencyinversion

interface IPolicyService {
    suspend fun getPostsPolicy(): List<Post>
}
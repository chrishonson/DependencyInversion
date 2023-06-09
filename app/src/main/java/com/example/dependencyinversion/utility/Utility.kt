package com.example.dependencyinversion.utility

import androidx.annotation.UiThread
import com.example.dependencyinversion.IMechanismService
import com.example.dependencyinversion.Post
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Utility layer implements the mechanism service interface
@UiThread
class Utility : IMechanismService {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val proxy: IMechanismService by lazy {
        retrofit.create(IMechanismService::class.java)
    }

    override suspend fun getPostsMechanism(): List<Post> {
        return proxy.getPostsMechanism()
    }


}

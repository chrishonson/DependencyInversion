package com.example.dependencyinversion.mechanism

import android.app.Application
import com.example.dependencyinversion.IPolicyService
import com.example.dependencyinversion.Post
import com.example.dependencyinversion.utility.UtilityFactory

class MechanismApplication : Application(), IPolicyService {
    override suspend fun getPosts(): List<Post> {
//i need to depend on IMechanismService
        return UtilityFactory.makeUtility().getPosts()
    }
}
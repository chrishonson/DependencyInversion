package com.example.dependencyinversion.mechanism

import android.app.Application
import com.example.dependencyinversion.IPolicyService
import com.example.dependencyinversion.Post
import com.example.dependencyinversion.utility.UtilityFactory
//Mechanism layer depends on the mechanism service interface
class MechanismApplication : Application(), IPolicyService {
    override suspend fun getPostsPolicy(): List<Post> {
//i depend on IMechanismService by composition through the utility factory
        return UtilityFactory.makeUtility().getPostsMechanism()
    }
}
package com.example.dependencyinversion.utility

class UtilityFactory {
    companion object {
        fun makeUtility(): Utility {
            return Utility()
        }
    }
}

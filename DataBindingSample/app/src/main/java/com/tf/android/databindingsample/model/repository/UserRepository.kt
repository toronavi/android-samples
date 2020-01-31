package com.tf.android.databindingsample.model.repository

import androidx.lifecycle.LiveData
import com.tf.android.databindingsample.model.datasource.LocalUserDataSource
import com.tf.android.databindingsample.model.model.User

class UserRepository {

    private val localDataSource = LocalUserDataSource()

    fun getUser(userId: String): LiveData<User> {
        return localDataSource.getUser(userId)
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(): UserRepository {
            return instance ?: synchronized(this) {
                instance ?: UserRepository().also { instance = it }
            }
        }
    }

}

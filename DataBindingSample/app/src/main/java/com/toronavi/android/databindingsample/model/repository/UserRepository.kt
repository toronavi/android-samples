package com.toronavi.android.databindingsample.model.repository

import androidx.lifecycle.LiveData
import com.toronavi.android.databindingsample.model.datasource.LocalUserDataSource
import com.toronavi.android.databindingsample.model.model.User

class UserRepository : IUserRepository {

    private val localDataSource = LocalUserDataSource()

    override fun getUser(userId: String): LiveData<User> {
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

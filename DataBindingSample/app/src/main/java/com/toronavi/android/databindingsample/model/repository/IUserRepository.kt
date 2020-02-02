package com.toronavi.android.databindingsample.model.repository

import androidx.lifecycle.LiveData
import com.toronavi.android.databindingsample.model.model.User

interface IUserRepository {

    fun getUser(userId: String): LiveData<User>

}
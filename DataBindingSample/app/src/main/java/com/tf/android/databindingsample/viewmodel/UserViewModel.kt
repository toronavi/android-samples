package com.tf.android.databindingsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tf.android.databindingsample.model.model.User
import com.tf.android.databindingsample.model.repository.UserRepository

class UserViewModel : ViewModel() {

    private val repository = UserRepository.getInstance()
    private val userId = MutableLiveData<String>()

    val user: LiveData<User> = Transformations.switchMap(userId) { userId ->
        repository.getUser(userId)
    }

    fun onItemSelected(item: String) {
        userId.value = item
    }

}

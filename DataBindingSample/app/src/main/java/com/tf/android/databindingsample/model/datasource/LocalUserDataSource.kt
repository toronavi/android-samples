package com.tf.android.databindingsample.model.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tf.android.databindingsample.model.model.User
import com.tf.android.databindingsample.model.model.UserBuilder

class LocalUserDataSource {

    private val userMap: Map<String, User>

    init {
        val builder = UserBuilder()

        val user1 = builder.setId("100000001")
            .setName("ひよこさん")
            .setIconId(1)
            .setIsFavorite(true)
            .build()

        val user2 = builder.setId("200000002")
            .setName("くまさん")
            .setIconId(2)
            .setIsFavorite(false)
            .build()

        val user3 = builder.setId("300000003")
            .setName("いぬさん")
            .setIconId(3)
            .setIsFavorite(true)
            .build()

        val user4 = builder.setId("400000004")
            .setName("ぬこさん")
            .setIconId(4)
            .setIsFavorite(false)
            .build()

        userMap = mutableMapOf<String, User>().apply {
            this[user1.id] = user1
            this[user2.id] = user2
            this[user3.id] = user3
            this[user4.id] = user4
        }
    }

    fun getUser(userId: String): LiveData<User> {
        val user = userMap[userId] ?: UserBuilder().build()
        return MutableLiveData<User>().apply {
            postValue(user)
        }
    }

}

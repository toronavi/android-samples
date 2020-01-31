package com.toronavi.android.databindingsample.model.model

data class User(
    val id: String,
    val name: String,
    val iconId: Int,
    val isFavorite: Boolean
)

class UserBuilder {

    private var mId: String = ""
    private var mName: String = ""
    private var mIconId: Int = 0
    private var mIsFavorite: Boolean = false

    fun setId(id: String): UserBuilder {
        mId = id
        return this
    }

    fun setName(name: String): UserBuilder {
        mName = name
        return this
    }

    fun setIconId(iconId: Int): UserBuilder {
        mIconId = iconId
        return this
    }

    fun setIsFavorite(isFavorite: Boolean): UserBuilder {
        mIsFavorite = isFavorite
        return this
    }

    fun build(): User {
        return User(mId, mName, mIconId, mIsFavorite)
    }

}
package com.toronavi.android.databindingsample.view.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.toronavi.android.databindingsample.R

object CommonBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:goneUnless")
    fun goneUnless(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("app:iconId")
    fun setIconById(view: AppCompatImageView, iconId: Int) {
        val resourceId = when (iconId) {
            1 -> R.drawable.avatar_01
            2 -> R.drawable.avatar_02
            3 -> R.drawable.avatar_03
            4 -> R.drawable.avatar_04
            else -> null
        }

        resourceId?.let {
            view.setImageResource(it)
        } ?: view.setImageDrawable(null)
    }

}
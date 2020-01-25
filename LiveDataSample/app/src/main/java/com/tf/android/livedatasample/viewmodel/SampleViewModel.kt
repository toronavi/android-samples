package com.tf.android.livedatasample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {

    private val mCount = MutableLiveData(0)

    val count: LiveData<Int> = mCount
    val countMessage: LiveData<String> = Transformations.map(count) { count ->
            "count number is $count"
    }

    fun onClickCountUp() {
        val currentCount = mCount.value ?: throw Exception("Invalid _count value")
        mCount.value = currentCount + 1
    }

}

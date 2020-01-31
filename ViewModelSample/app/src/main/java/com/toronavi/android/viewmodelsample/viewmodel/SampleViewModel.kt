package com.toronavi.android.viewmodelsample.viewmodel

import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {

    var count: Int = 0
        private set

    fun onClickCountUp() {
        count++
    }

}

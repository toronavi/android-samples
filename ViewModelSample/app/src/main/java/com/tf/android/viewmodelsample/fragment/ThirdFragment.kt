package com.tf.android.viewmodelsample.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tf.android.viewmodelsample.R
import com.tf.android.viewmodelsample.viewmodel.SampleViewModel

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private lateinit var fragmentValueView: AppCompatTextView
    private lateinit var viewModelValueView: AppCompatTextView
    private var count = 0
    private lateinit var model: SampleViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentValueView = view.findViewById(R.id.fragmentValueView)
        viewModelValueView = view.findViewById(R.id.viewModelValueView)

        model = ViewModelProviders.of(this)[SampleViewModel::class.java]

        val countUpButton = view.findViewById<AppCompatButton>(R.id.countUpButton)
        countUpButton.setOnClickListener {
            count++
            model.onClickCountUp()
            updateView()
        }

        updateView()
    }

    private fun updateView() {
        fragmentValueView.text = count.toString()
        viewModelValueView.text = model.count.toString()
    }

}
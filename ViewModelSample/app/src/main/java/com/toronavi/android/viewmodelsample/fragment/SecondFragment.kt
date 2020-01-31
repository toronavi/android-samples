package com.toronavi.android.viewmodelsample.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.toronavi.android.viewmodelsample.R
import com.toronavi.android.viewmodelsample.viewmodel.SampleViewModel

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var fragmentValueView: AppCompatTextView
    private lateinit var viewModelValueView: AppCompatTextView
    private var count = 0
    private lateinit var model: SampleViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentValueView = view.findViewById(R.id.fragmentValueView)
        viewModelValueView = view.findViewById(R.id.viewModelValueView)

        model = activity?.run {
            ViewModelProviders.of(this)[SampleViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val countUpButton = view.findViewById<AppCompatButton>(R.id.countUpButton)
        countUpButton.setOnClickListener {
            count++
            model.onClickCountUp()
            updateView()
        }
        val nextButton = view.findViewById<AppCompatButton>(R.id.nextButton)
        nextButton.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            findNavController().navigate(action)
        }

        updateView()
    }

    private fun updateView() {
        fragmentValueView.text = count.toString()
        viewModelValueView.text = model.count.toString()
    }

}
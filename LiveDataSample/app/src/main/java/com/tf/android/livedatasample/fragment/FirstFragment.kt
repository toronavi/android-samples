package com.tf.android.livedatasample.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tf.android.livedatasample.R
import com.tf.android.livedatasample.viewmodel.SampleViewModel

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProviders.of(this)[SampleViewModel::class.java]

        view.findViewById<AppCompatButton>(R.id.countUpButton).apply {
            setOnClickListener {
                model.onClickCountUp()
            }
        }

        val viewModelValueView = view.findViewById<AppCompatTextView>(R.id.viewModelValueView)
        model.count.observe(viewLifecycleOwner, Observer { count ->
            viewModelValueView.text = count.toString()
        })

        val countMessageView = view.findViewById<AppCompatTextView>(R.id.countMessageView)
        model.countMessage.observe(viewLifecycleOwner, Observer { countMessage ->
            countMessageView.text = countMessage
        })
    }

}
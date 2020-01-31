package com.toronavi.android.navigationsample.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.toronavi.android.navigationsample.R
import com.toronavi.android.navigationsample.data.TransitionData

class ThirdFragment : Fragment(R.layout.fragment_third) {

    companion object {
        private var counter = 0
    }

    private val args: ThirdFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.nextButton).apply {
            setOnClickListener {
                val transitionData = TransitionData(++counter)
                val action =
                    ThirdFragmentDirections.actionThirdFragmentToForceFragment(transitionData)
                findNavController().navigate(action)
            }
        }
        view.findViewById<TextView>(R.id.messageView).apply {
            text = args.counter.toString()
        }
    }

}
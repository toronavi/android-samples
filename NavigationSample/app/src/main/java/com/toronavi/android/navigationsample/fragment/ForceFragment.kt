package com.toronavi.android.navigationsample.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.toronavi.android.navigationsample.R

class ForceFragment : Fragment(R.layout.fragment_force) {

    private val args: ForceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatButton>(R.id.nextButton).apply {
            setOnClickListener {
                val action = ForceFragmentDirections.actionForceFragmentToFifthFragment()
                findNavController().navigate(action)
            }
        }
        view.findViewById<TextView>(R.id.messageView).apply {
            text = args.transitionData?.message
        }
    }

}
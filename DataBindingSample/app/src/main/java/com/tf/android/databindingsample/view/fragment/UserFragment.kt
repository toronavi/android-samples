package com.tf.android.databindingsample.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tf.android.databindingsample.R
import com.tf.android.databindingsample.databinding.FragmentUserBinding
import com.tf.android.databindingsample.viewmodel.UserViewModel

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this)[UserViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.common_spinner,
            resources.getStringArray(R.array.user_list)
        )
        binding.selectUserSpinner.apply {

            setAdapter(adapter)

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinner = parent as AppCompatSpinner
                    val str = spinner.selectedItem.toString()
                    viewModel.onItemSelected(str)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Do nothing
                }
            }
        }
    }

}
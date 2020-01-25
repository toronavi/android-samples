package com.tf.android.lifecycelsample.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(javaClass.name, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(javaClass.name, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(javaClass.name, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(javaClass.name, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(javaClass.name, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(javaClass.name, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(javaClass.name, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(javaClass.name, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(javaClass.name, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(javaClass.name, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(javaClass.name, "onDetach")
    }

}

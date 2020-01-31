package com.toronavi.android.lifecycelsample.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(javaClass.name, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(javaClass.name, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(javaClass.name, "onRestart")
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

    override fun onDestroy() {
        super.onDestroy()
        Log.d(javaClass.name, "onDestroy")
    }

}

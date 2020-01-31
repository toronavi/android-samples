package com.toronavi.android.lifecycelsample.activity

import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.toronavi.android.lifecycelsample.R
import com.toronavi.android.lifecycelsample.fragment.FirstFragment
import com.toronavi.android.lifecycelsample.fragment.SecondFragment

open class SecondActivity : BaseActivity() {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        addFragment()

        val closeButton = findViewById<AppCompatButton>(R.id.closeActivityButton)
        closeButton.setOnClickListener {
            onClickCloseButton()
        }
        val switchButton = findViewById<AppCompatButton>(R.id.switchFragmentButton)
        switchButton.setOnClickListener {
            onClickSwitchButton()
        }
    }

    private fun addFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val targetFragment = FirstFragment()
        currentFragment = targetFragment
        fragmentTransaction.add(R.id.fragment, targetFragment)
        fragmentTransaction.commit()
    }

    private fun onClickCloseButton() {
        finish()
    }

    private fun onClickSwitchButton() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val targetFragment = if (currentFragment is FirstFragment) {
            SecondFragment()
        } else {
            FirstFragment()
        }
        currentFragment = targetFragment
        fragmentTransaction.replace(R.id.fragment, targetFragment)
        fragmentTransaction.commit()
    }

}

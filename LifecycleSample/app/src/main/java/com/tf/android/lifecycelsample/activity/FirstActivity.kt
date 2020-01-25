package com.tf.android.lifecycelsample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.tf.android.lifecycelsample.R

class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val button = findViewById<AppCompatButton>(R.id.firstActivityButton)
        button.setOnClickListener {
            onClickButton()
        }
    }

    private fun onClickButton() {
        startActivity(Intent(this, SecondActivity::class.java))
    }

}

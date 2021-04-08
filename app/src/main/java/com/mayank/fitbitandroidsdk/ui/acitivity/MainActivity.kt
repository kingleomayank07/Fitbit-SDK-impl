package com.mayank.fitbitandroidsdk.ui.acitivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mayank.fitbitandroidsdk.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, FitbitActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
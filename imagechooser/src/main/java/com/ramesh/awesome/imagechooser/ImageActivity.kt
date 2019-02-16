package com.ramesh.awesome.imagechooser

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    companion object {
        fun getCallingIntent(activity: Activity?): Intent? {
            val intent = Intent(activity, ImageActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
    }
}

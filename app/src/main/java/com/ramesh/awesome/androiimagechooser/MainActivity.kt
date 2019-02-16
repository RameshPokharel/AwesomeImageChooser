package com.ramesh.awesome.androiimagechooser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramesh.awesome.imagechooser.AwesomeChooser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AwesomeChooser.Builder(this).allowMultipleImages(true).build()
    }
}

package com.ramesh.awesome.androiimagechooser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramesh.awesome.imagechooser.AwesomeChooser
import com.ramesh.awesome.imagechooser.config.PictureConfig
import com.ramesh.awesome.imagechooser.config.PictureMimeType
/**
 * author：Ramesh
 * data：2019/2/16
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AwesomeChooser.Builder(this)
            .isCamera(true)
            .maxSelectNum(5)
            .minSelectNum(1)
            .selectionMode(PictureConfig.MULTIPLE)
            .openGallery(PictureMimeType.ofAll())
            .compress(true).build()

    }
}

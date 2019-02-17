package com.ramesh.awesome.imagechooser

import android.app.Activity
import android.content.Intent
import com.ramesh.awesome.imagechooser.config.PictureConfig
import com.ramesh.awesome.imagechooser.config.PictureMimeType
import java.lang.ref.WeakReference

public class AwesomeChooser(build: Builder) {
    private var activity: WeakReference<Activity>
    private val imageConfig: ImageConfig

    init {
        this.activity = build.activity
        imageConfig = build.imageConfig
        val intent = Intent(this.activity.get(), PictureSelectorActivity::class.java)
            intent.putExtra(PictureConfig.EXTRA_CONFIG, imageConfig)
        this.activity.get()?.startActivityForResult(intent, 0)
    }

    open class Builder(activity: Activity) : BuilderBase() {
        var imageConfig = ImageConfig()
        var activity: WeakReference<Activity> = WeakReference(activity)


        override fun selectionMode(mode: Int): Builder {
            imageConfig.selectionMode = mode
            return this
        }

        override fun openGallery(type: Int): Builder {
            imageConfig.mimeType = type
            return this
        }

        override fun theme(id: Int): Builder {
            imageConfig.theme =R.style.picture_default_style

            return this
        }

        override fun maxSelectNum(max: Int): Builder {
            imageConfig.max = max
            return this
        }

        override fun minSelectNum(min: Int): Builder {
            imageConfig.min = min
            return this
        }

        override fun previewImage(boolean: Boolean): Builder {
            imageConfig.isPreview = boolean
            return this
        }

        override fun isCamera(boolean: Boolean): Builder {
            imageConfig.isCamera = boolean
            return this
        }

        override fun setOutputCameraPath(path: String): Builder {
            imageConfig.cameraPath = path
            return this
        }

        override fun compress(boolean: Boolean): Builder {
            imageConfig.compress = boolean
            return this
        }

        override fun forResult(id: PictureConfig): Builder {
            imageConfig.forResult = id
            return this
        }

        public fun build(): AwesomeChooser {
            return AwesomeChooser(this)
        }
    }


}
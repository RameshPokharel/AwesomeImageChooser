package com.ramesh.awesome.imagechooser

import com.ramesh.awesome.imagechooser.config.PictureConfig
import com.ramesh.awesome.imagechooser.config.PictureMimeType


public abstract class BuilderBase {

    abstract fun selectionMode(mode: Int): AwesomeChooser.Builder //multiple
    abstract fun openGallery(type: Int): AwesomeChooser.Builder
    abstract fun theme(id: Int): AwesomeChooser.Builder
    abstract fun maxSelectNum(max: Int): AwesomeChooser.Builder
    abstract fun minSelectNum(min: Int): AwesomeChooser.Builder
    abstract fun previewImage(boolean: Boolean): AwesomeChooser.Builder
    abstract fun isCamera(boolean: Boolean): AwesomeChooser.Builder
    abstract fun setOutputCameraPath(path: String): AwesomeChooser.Builder
    abstract fun compress(boolean: Boolean): AwesomeChooser.Builder
    abstract fun forResult(id: PictureConfig): AwesomeChooser.Builder
}
package com.ramesh.awesome.imagechooser

import android.app.Activity
import java.lang.ref.WeakReference

public class AwesomeChooser(build: Builder) {
    private var activity: WeakReference<Activity>
    private var isAllow: Boolean?

    init {
        this.activity = build.activity
        this.isAllow = build.isAllow
        var intent = ImageActivity.getCallingIntent(this.activity.get())
        this.activity.get()?.startActivityForResult(intent, 0)
    }

    open class Builder(activity: Activity) {
        var activity: WeakReference<Activity> = WeakReference(activity)
        var isAllow: Boolean? = false

        public fun allowMultipleImages(isAllow: Boolean): Builder {
            this.isAllow = isAllow
            return this
        }

        public fun build(): AwesomeChooser {
            return AwesomeChooser(this)
        }
    }

}
package com.ramesh.awesome.imagechooser

import android.content.Intent
import android.os.Bundle
import com.ramesh.awesome.imagechooser.config.PictureConfig
import com.ramesh.awesome.imagechooser.entity.LocalMedia
import java.io.Serializable
import java.util.ArrayList

class ImageSelector
{
    companion object {
        fun putIntentResult(data: List<LocalMedia>): Intent {
            return Intent().putExtra(PictureConfig.EXTRA_RESULT_SELECTION, data as Serializable)
        }

        fun obtainSelectorList(bundle: Bundle?): List<LocalMedia> {
            val selectionMedias: List<LocalMedia>
            if (bundle != null) {
                selectionMedias = bundle
                    .getSerializable(PictureConfig.EXTRA_SELECT_LIST) as List<LocalMedia>
                return selectionMedias
            }
            selectionMedias = ArrayList<LocalMedia>()
            return selectionMedias
        }

        /**
         * @param selectedImages
         * @return put Selector  LocalMedia
         */
        fun saveSelectorList(outState: Bundle, selectedImages: List<LocalMedia>) {
            outState.putSerializable(PictureConfig.EXTRA_SELECT_LIST, selectedImages as Serializable)
        }
    }
}
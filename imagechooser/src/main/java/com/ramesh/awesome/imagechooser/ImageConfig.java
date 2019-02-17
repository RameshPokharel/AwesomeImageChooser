package com.ramesh.awesome.imagechooser;

import android.os.Parcel;
import android.os.Parcelable;
import com.ramesh.awesome.imagechooser.config.PictureConfig;
import com.ramesh.awesome.imagechooser.entity.LocalMedia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alhazmy13 on 8/16/16.
 * MediaPicker
 */
public class ImageConfig implements Parcelable {
    public List<LocalMedia> selectionMedias;

    public int mimeType;
    public int selectionMode;
    public int theme;
    public int max;
    public int min;
    public boolean isPreview;
    public boolean isCamera;
    public boolean imageFormat;
    public String cameraPath;
    public boolean compress;
    public PictureConfig forResult;

    protected ImageConfig(Parcel in) {
        selectionMedias = in.createTypedArrayList(LocalMedia.CREATOR);
        mimeType = in.readInt();
        selectionMode = in.readInt();
        theme = in.readInt();
        max = in.readInt();
        min = in.readInt();
        isPreview = in.readByte() != 0;
        isCamera = in.readByte() != 0;
        imageFormat = in.readByte() != 0;
        cameraPath = in.readString();
        compress = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(selectionMedias);
        dest.writeInt(mimeType);
        dest.writeInt(selectionMode);
        dest.writeInt(theme);
        dest.writeInt(max);
        dest.writeInt(min);
        dest.writeByte((byte) (isPreview ? 1 : 0));
        dest.writeByte((byte) (isCamera ? 1 : 0));
        dest.writeByte((byte) (imageFormat ? 1 : 0));
        dest.writeString(cameraPath);
        dest.writeByte((byte) (compress ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImageConfig> CREATOR = new Creator<ImageConfig>() {
        @Override
        public ImageConfig createFromParcel(Parcel in) {
            return new ImageConfig(in);
        }

        @Override
        public ImageConfig[] newArray(int size) {
            return new ImageConfig[size];
        }
    };

    public static ImageConfig getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static ImageConfig getCleanInstance() {
        ImageConfig selectionSpec = getInstance();
        selectionSpec.reset();
        return selectionSpec;
    }

    private static final class InstanceHolder {
        private static final ImageConfig INSTANCE = new ImageConfig();
    }


    private void reset() {
        mimeType = PictureConfig.TYPE_IMAGE;
        isCamera = false;
        theme = R.style.picture_default_style;
        selectionMode = PictureConfig.MULTIPLE;
        max = 9;
        min = 0;
        isPreview=false;
        imageFormat=true;
        compress = false;
        isCamera = true;
        selectionMedias = new ArrayList<>();

    }

}

package com.ramesh.awesome.imagechooser.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.StyleRes;
import com.ramesh.awesome.imagechooser.R;
import com.ramesh.awesome.imagechooser.entity.LocalMedia;
import com.ramesh.awesome.imagechooser.tools.PictureFileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * author：Ramesh
 * data：2019/2/16
 */

public final class PictureSelectionConfig implements Parcelable {
    public int mimeType;
    public boolean camera;
    public String outputCameraPath;
    public String compressSavePath;
    public String suffixType;
    @StyleRes
    public int themeStyleId;
    public int selectionMode;
    public int maxSelectNum;
    public int minSelectNum;
    public int cropCompressQuality;
    public int minimumCompressSize;
    public int imageSpanCount;
    public int overrideWidth;
    public int overrideHeight;
    public int aspect_ratio_x;
    public int aspect_ratio_y;
    public float sizeMultiplier;
    public int cropWidth;
    public int cropHeight;
    public boolean isCompress;
    public boolean isCamera;
    public boolean enablePreview;
    public boolean enableCrop;
    public boolean circleDimmedLayer;
    public boolean showCropGrid;
    public boolean synOrAsy;
    public boolean isDragFrame;

    public List<LocalMedia> selectionMedias;

    private void reset() {
        mimeType = PictureConfig.TYPE_IMAGE;
        camera = false;
        themeStyleId = R.style.picture_default_style;
        selectionMode = PictureConfig.MULTIPLE;
        maxSelectNum = 9;
        minSelectNum = 0;
        cropCompressQuality = 90;
        minimumCompressSize = PictureConfig.MAX_COMPRESS_SIZE;
        imageSpanCount = 4;
        overrideWidth = 0;
        overrideHeight = 0;
        isCompress = false;
        aspect_ratio_x = 0;
        aspect_ratio_y = 0;
        cropWidth = 0;
        cropHeight = 0;
        isCamera = true;
        enablePreview = true;
        enableCrop = false;
        circleDimmedLayer = false;
        showCropGrid = true;
        synOrAsy = true;
        isDragFrame = true;
        outputCameraPath = "";
        compressSavePath = "";
        suffixType = PictureFileUtils.POSTFIX;
        sizeMultiplier = 0.5f;
        selectionMedias = new ArrayList<>();
    }

    public static PictureSelectionConfig getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static PictureSelectionConfig getCleanInstance() {
        PictureSelectionConfig selectionSpec = getInstance();
        selectionSpec.reset();
        return selectionSpec;
    }

    private static final class InstanceHolder {
        private static final PictureSelectionConfig INSTANCE = new PictureSelectionConfig();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mimeType);
        dest.writeByte(this.camera ? (byte) 1 : (byte) 0);
        dest.writeString(this.outputCameraPath);
        dest.writeString(this.compressSavePath);
        dest.writeString(this.suffixType);
        dest.writeInt(this.themeStyleId);
        dest.writeInt(this.selectionMode);
        dest.writeInt(this.maxSelectNum);
        dest.writeInt(this.minSelectNum);
        dest.writeInt(this.cropCompressQuality);
        dest.writeInt(this.minimumCompressSize);
        dest.writeInt(this.imageSpanCount);
        dest.writeInt(this.overrideWidth);
        dest.writeInt(this.overrideHeight);
        dest.writeInt(this.aspect_ratio_x);
        dest.writeInt(this.aspect_ratio_y);
        dest.writeFloat(this.sizeMultiplier);
        dest.writeInt(this.cropWidth);
        dest.writeInt(this.cropHeight);
        dest.writeByte(this.isCompress ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isCamera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enablePreview ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableCrop ? (byte) 1 : (byte) 0);
        dest.writeByte(this.circleDimmedLayer ? (byte) 1 : (byte) 0);
        dest.writeByte(this.showCropGrid ? (byte) 1 : (byte) 0);
        dest.writeByte(this.synOrAsy ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDragFrame ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.selectionMedias);
    }

    public PictureSelectionConfig() {
    }

    protected PictureSelectionConfig(Parcel in) {
        this.mimeType = in.readInt();
        this.camera = in.readByte() != 0;
        this.outputCameraPath = in.readString();
        this.compressSavePath = in.readString();
        this.suffixType = in.readString();
        this.themeStyleId = in.readInt();
        this.selectionMode = in.readInt();
        this.maxSelectNum = in.readInt();
        this.minSelectNum = in.readInt();
        this.cropCompressQuality = in.readInt();
        this.minimumCompressSize = in.readInt();
        this.imageSpanCount = in.readInt();
        this.overrideWidth = in.readInt();
        this.overrideHeight = in.readInt();
        this.aspect_ratio_x = in.readInt();
        this.aspect_ratio_y = in.readInt();
        this.sizeMultiplier = in.readFloat();
        this.cropWidth = in.readInt();
        this.cropHeight = in.readInt();
        this.isCompress = in.readByte() != 0;
        this.isCamera = in.readByte() != 0;
        this.enablePreview = in.readByte() != 0;
        this.enableCrop = in.readByte() != 0;
        this.circleDimmedLayer = in.readByte() != 0;
        this.showCropGrid = in.readByte() != 0;
        this.synOrAsy = in.readByte() != 0;
        this.isDragFrame = in.readByte() != 0;
        this.selectionMedias = in.createTypedArrayList(LocalMedia.CREATOR);
    }

    public static final Parcelable.Creator<PictureSelectionConfig> CREATOR = new Parcelable.Creator<PictureSelectionConfig>() {
        @Override
        public PictureSelectionConfig createFromParcel(Parcel source) {
            return new PictureSelectionConfig(source);
        }

        @Override
        public PictureSelectionConfig[] newArray(int size) {
            return new PictureSelectionConfig[size];
        }
    };
}

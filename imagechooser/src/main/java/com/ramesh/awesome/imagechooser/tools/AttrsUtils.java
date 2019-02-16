package com.ramesh.awesome.imagechooser.tools;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/**
 * author：Ramesh
 * data：2019/2/16
 */
public class AttrsUtils {
    /**
     * get attrs color
     *
     * @param mContext
     * @param attr
     * @return
     */
    public static int getTypeValueColor(Context mContext, int attr) {
        TypedValue typedValue = new TypedValue();
        int[] attribute = new int[]{attr};
        TypedArray array = mContext.obtainStyledAttributes(typedValue.resourceId, attribute);
        int color = array.getColor(0, -1);
        array.recycle();
        return color;
    }

    /**
     * attrs status color or black
     *
     * @param mContext
     * @param attr
     * @return
     */
    public static boolean getTypeValueBoolean(Context mContext, int attr) {
        TypedValue typedValue = new TypedValue();
        int[] attribute = new int[]{attr};
        TypedArray array = mContext.obtainStyledAttributes(typedValue.resourceId, attribute);
        boolean statusFont = array.getBoolean(0, false);
        array.recycle();
        return statusFont;
    }

    /**
     * attrs PopupWindow down or up icon
     *
     * @param mContext
     * @param attr
     * @return
     */
    public static Drawable getTypeValuePopWindowImg(Context mContext, int attr) {
        TypedValue typedValue = new TypedValue();
        int[] attribute = new int[]{attr};
        TypedArray array = mContext.obtainStyledAttributes(typedValue.resourceId, attribute);
        Drawable drawable = array.getDrawable(0);
        array.recycle();
        return drawable;
    }
}

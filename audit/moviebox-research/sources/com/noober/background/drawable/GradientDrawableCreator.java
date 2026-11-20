package com.noober.background.drawable;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import com.noober.background.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientDrawableCreator implements ICreateDrawable {
    private int gradientState;
    private TypedArray typedArray;

    public GradientDrawableCreator(TypedArray typedArray) {
        this.gradientState = -1;
        this.typedArray = typedArray;
    }

    public GradientDrawableCreator(TypedArray typedArray, int i11) {
        this.typedArray = typedArray;
        this.gradientState = i11;
    }

    private boolean hasSetRadius(float[] fArr) {
        for (float f11 : fArr) {
            if (f11 != 0.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public GradientDrawable create() throws XmlPullParserException {
        int[] iArr;
        int i11;
        GradientDrawable gradientDrawable = new GradientDrawable();
        float[] fArr = new float[8];
        Rect rect = new Rect();
        int i12 = 0;
        int i13 = 0;
        float dimension = 0.0f;
        float dimension2 = 0.0f;
        int color = 0;
        float dimension3 = -1.0f;
        float dimension4 = 0.0f;
        int color2 = 0;
        float dimension5 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int color3 = 0;
        int color4 = 0;
        int color5 = 0;
        int i14 = 0;
        int integer = 0;
        while (i13 < this.typedArray.getIndexCount()) {
            int index = this.typedArray.getIndex(i13);
            if (index == R.styleable.background_bl_shape) {
                gradientDrawable.setShape(this.typedArray.getInt(index, i12));
            } else if (index == R.styleable.background_bl_solid_color) {
                color = this.typedArray.getColor(index, i12);
            } else if (index == R.styleable.background_bl_corners_radius) {
                gradientDrawable.setCornerRadius(this.typedArray.getDimension(index, 0.0f));
            } else if (index == R.styleable.background_bl_corners_bottomLeftRadius) {
                fArr[6] = this.typedArray.getDimension(index, 0.0f);
                fArr[7] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_bottomRightRadius) {
                fArr[4] = this.typedArray.getDimension(index, 0.0f);
                fArr[5] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_topLeftRadius) {
                fArr[0] = this.typedArray.getDimension(index, 0.0f);
                fArr[1] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_topRightRadius) {
                fArr[2] = this.typedArray.getDimension(index, 0.0f);
                fArr[3] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_leftRadius) {
                fArr[0] = this.typedArray.getDimension(index, 0.0f);
                fArr[1] = this.typedArray.getDimension(index, 0.0f);
                fArr[6] = this.typedArray.getDimension(index, 0.0f);
                fArr[7] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_topRadius) {
                fArr[0] = this.typedArray.getDimension(index, 0.0f);
                fArr[1] = this.typedArray.getDimension(index, 0.0f);
                fArr[2] = this.typedArray.getDimension(index, 0.0f);
                fArr[3] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_rightRadius) {
                fArr[2] = this.typedArray.getDimension(index, 0.0f);
                fArr[3] = this.typedArray.getDimension(index, 0.0f);
                fArr[4] = this.typedArray.getDimension(index, 0.0f);
                fArr[5] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_bottomRadius) {
                fArr[4] = this.typedArray.getDimension(index, 0.0f);
                fArr[5] = this.typedArray.getDimension(index, 0.0f);
                fArr[6] = this.typedArray.getDimension(index, 0.0f);
                fArr[7] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_gradient_angle || index == R.styleable.background_bl_checkable_gradient_angle || index == R.styleable.background_bl_unCheckable_gradient_angle || index == R.styleable.background_bl_checked_gradient_angle || index == R.styleable.background_bl_unChecked_gradient_angle || index == R.styleable.background_bl_enabled_gradient_angle || index == R.styleable.background_bl_unEnabled_gradient_angle || index == R.styleable.background_bl_selected_gradient_angle || index == R.styleable.background_bl_unSelected_gradient_angle || index == R.styleable.background_bl_pressed_gradient_angle || index == R.styleable.background_bl_unPressed_gradient_angle || index == R.styleable.background_bl_focused_gradient_angle || index == R.styleable.background_bl_unFocused_gradient_angle) {
                int i15 = this.gradientState;
                if (i15 == -1) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == 16842911 && index == R.styleable.background_bl_checkable_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == 16842912 && index == R.styleable.background_bl_checked_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == 16842910 && index == R.styleable.background_bl_enabled_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == 16842913 && index == R.styleable.background_bl_selected_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == 16842919 && index == R.styleable.background_bl_pressed_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == 16842908 && index == R.styleable.background_bl_focused_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                } else if (i15 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_angle) {
                    integer = this.typedArray.getInteger(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_centerX || index == R.styleable.background_bl_checkable_gradient_centerX || index == R.styleable.background_bl_unCheckable_gradient_centerX || index == R.styleable.background_bl_checked_gradient_centerX || index == R.styleable.background_bl_unChecked_gradient_centerX || index == R.styleable.background_bl_enabled_gradient_centerX || index == R.styleable.background_bl_unEnabled_gradient_centerX || index == R.styleable.background_bl_selected_gradient_centerX || index == R.styleable.background_bl_unSelected_gradient_centerX || index == R.styleable.background_bl_pressed_gradient_centerX || index == R.styleable.background_bl_unPressed_gradient_centerX || index == R.styleable.background_bl_focused_gradient_centerX || index == R.styleable.background_bl_unFocused_gradient_centerX) {
                int i16 = this.gradientState;
                if (i16 == -1) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == 16842912 && index == R.styleable.background_bl_checked_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == 16842913 && index == R.styleable.background_bl_selected_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == 16842908 && index == R.styleable.background_bl_focused_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                } else if (i16 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerX) {
                    f11 = this.typedArray.getFloat(index, -1.0f);
                }
            } else if (index == R.styleable.background_bl_gradient_centerY || index == R.styleable.background_bl_checkable_gradient_centerY || index == R.styleable.background_bl_unCheckable_gradient_centerY || index == R.styleable.background_bl_checked_gradient_centerY || index == R.styleable.background_bl_unChecked_gradient_centerY || index == R.styleable.background_bl_enabled_gradient_centerY || index == R.styleable.background_bl_unEnabled_gradient_centerY || index == R.styleable.background_bl_selected_gradient_centerY || index == R.styleable.background_bl_unSelected_gradient_centerY || index == R.styleable.background_bl_pressed_gradient_centerY || index == R.styleable.background_bl_unPressed_gradient_centerY || index == R.styleable.background_bl_focused_gradient_centerY || index == R.styleable.background_bl_unFocused_gradient_centerY) {
                int i17 = this.gradientState;
                if (i17 == -1) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == 16842912 && index == R.styleable.background_bl_checked_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == 16842913 && index == R.styleable.background_bl_selected_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == 16842908 && index == R.styleable.background_bl_focused_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                } else if (i17 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerY) {
                    f12 = this.typedArray.getFloat(index, -1.0f);
                }
            } else if (index == R.styleable.background_bl_gradient_centerColor || index == R.styleable.background_bl_checkable_gradient_centerColor || index == R.styleable.background_bl_unCheckable_gradient_centerColor || index == R.styleable.background_bl_checked_gradient_centerColor || index == R.styleable.background_bl_unChecked_gradient_centerColor || index == R.styleable.background_bl_enabled_gradient_centerColor || index == R.styleable.background_bl_unEnabled_gradient_centerColor || index == R.styleable.background_bl_selected_gradient_centerColor || index == R.styleable.background_bl_unSelected_gradient_centerColor || index == R.styleable.background_bl_pressed_gradient_centerColor || index == R.styleable.background_bl_unPressed_gradient_centerColor || index == R.styleable.background_bl_focused_gradient_centerColor || index == R.styleable.background_bl_unFocused_gradient_centerColor) {
                int i18 = this.gradientState;
                if (i18 == -1) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == 16842912 && index == R.styleable.background_bl_checked_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == 16842913 && index == R.styleable.background_bl_selected_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == 16842908 && index == R.styleable.background_bl_focused_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                } else if (i18 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerColor) {
                    color3 = this.typedArray.getColor(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_endColor || index == R.styleable.background_bl_checkable_gradient_endColor || index == R.styleable.background_bl_unCheckable_gradient_endColor || index == R.styleable.background_bl_checked_gradient_endColor || index == R.styleable.background_bl_unChecked_gradient_endColor || index == R.styleable.background_bl_enabled_gradient_endColor || index == R.styleable.background_bl_unEnabled_gradient_endColor || index == R.styleable.background_bl_selected_gradient_endColor || index == R.styleable.background_bl_unSelected_gradient_endColor || index == R.styleable.background_bl_pressed_gradient_endColor || index == R.styleable.background_bl_unPressed_gradient_endColor || index == R.styleable.background_bl_focused_gradient_endColor || index == R.styleable.background_bl_unFocused_gradient_endColor) {
                int i19 = this.gradientState;
                if (i19 == -1) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == 16842911 && index == R.styleable.background_bl_checkable_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == 16842912 && index == R.styleable.background_bl_checked_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == 16842910 && index == R.styleable.background_bl_enabled_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == 16842913 && index == R.styleable.background_bl_selected_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == 16842919 && index == R.styleable.background_bl_pressed_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == 16842908 && index == R.styleable.background_bl_focused_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                } else if (i19 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_endColor) {
                    color5 = this.typedArray.getColor(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_startColor || index == R.styleable.background_bl_checkable_gradient_startColor || index == R.styleable.background_bl_unCheckable_gradient_startColor || index == R.styleable.background_bl_checked_gradient_startColor || index == R.styleable.background_bl_unChecked_gradient_startColor || index == R.styleable.background_bl_enabled_gradient_startColor || index == R.styleable.background_bl_unEnabled_gradient_startColor || index == R.styleable.background_bl_selected_gradient_startColor || index == R.styleable.background_bl_unSelected_gradient_startColor || index == R.styleable.background_bl_pressed_gradient_startColor || index == R.styleable.background_bl_unPressed_gradient_startColor || index == R.styleable.background_bl_focused_gradient_startColor || index == R.styleable.background_bl_unFocused_gradient_startColor) {
                int i21 = this.gradientState;
                if (i21 == -1) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == 16842911 && index == R.styleable.background_bl_checkable_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == 16842912 && index == R.styleable.background_bl_checked_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == 16842910 && index == R.styleable.background_bl_enabled_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == 16842913 && index == R.styleable.background_bl_selected_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == 16842919 && index == R.styleable.background_bl_pressed_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == 16842908 && index == R.styleable.background_bl_focused_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                } else if (i21 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_startColor) {
                    color4 = this.typedArray.getColor(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_gradientRadius || index == R.styleable.background_bl_checkable_gradient_gradientRadius || index == R.styleable.background_bl_unCheckable_gradient_gradientRadius || index == R.styleable.background_bl_checked_gradient_gradientRadius || index == R.styleable.background_bl_unChecked_gradient_gradientRadius || index == R.styleable.background_bl_enabled_gradient_gradientRadius || index == R.styleable.background_bl_unEnabled_gradient_gradientRadius || index == R.styleable.background_bl_selected_gradient_gradientRadius || index == R.styleable.background_bl_unSelected_gradient_gradientRadius || index == R.styleable.background_bl_pressed_gradient_gradientRadius || index == R.styleable.background_bl_unPressed_gradient_gradientRadius || index == R.styleable.background_bl_focused_gradient_gradientRadius || index == R.styleable.background_bl_unFocused_gradient_gradientRadius) {
                int i22 = this.gradientState;
                if (i22 == -1) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == 16842911 && index == R.styleable.background_bl_checkable_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == 16842912 && index == R.styleable.background_bl_checked_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == 16842910 && index == R.styleable.background_bl_enabled_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == 16842913 && index == R.styleable.background_bl_selected_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == 16842919 && index == R.styleable.background_bl_pressed_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == 16842908 && index == R.styleable.background_bl_focused_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i22 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                }
            } else if (index == R.styleable.background_bl_gradient_type || index == R.styleable.background_bl_checkable_gradient_type || index == R.styleable.background_bl_unCheckable_gradient_type || index == R.styleable.background_bl_checked_gradient_type || index == R.styleable.background_bl_unChecked_gradient_type || index == R.styleable.background_bl_enabled_gradient_type || index == R.styleable.background_bl_unEnabled_gradient_type || index == R.styleable.background_bl_selected_gradient_type || index == R.styleable.background_bl_unSelected_gradient_type || index == R.styleable.background_bl_pressed_gradient_type || index == R.styleable.background_bl_unPressed_gradient_type || index == R.styleable.background_bl_focused_gradient_type || index == R.styleable.background_bl_unFocused_gradient_type) {
                int i23 = this.gradientState;
                if (i23 == -1) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == 16842911 && index == R.styleable.background_bl_checkable_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == 16842912 && index == R.styleable.background_bl_checked_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == 16842910 && index == R.styleable.background_bl_enabled_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == 16842913 && index == R.styleable.background_bl_selected_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == 16842919 && index == R.styleable.background_bl_pressed_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == 16842908 && index == R.styleable.background_bl_focused_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                } else if (i23 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_type) {
                    i14 = this.typedArray.getInt(index, 0);
                }
                int i24 = i14;
                gradientDrawable.setGradientType(i24);
                i14 = i24;
            } else if (index == R.styleable.background_bl_gradient_useLevel || index == R.styleable.background_bl_checkable_gradient_useLevel || index == R.styleable.background_bl_unCheckable_gradient_useLevel || index == R.styleable.background_bl_checked_gradient_useLevel || index == R.styleable.background_bl_unChecked_gradient_useLevel || index == R.styleable.background_bl_enabled_gradient_useLevel || index == R.styleable.background_bl_unEnabled_gradient_useLevel || index == R.styleable.background_bl_selected_gradient_useLevel || index == R.styleable.background_bl_unSelected_gradient_useLevel || index == R.styleable.background_bl_pressed_gradient_useLevel || index == R.styleable.background_bl_unPressed_gradient_useLevel || index == R.styleable.background_bl_focused_gradient_useLevel || index == R.styleable.background_bl_unFocused_gradient_useLevel) {
                int i25 = this.gradientState;
                if (i25 == -1) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == 16842911 && index == R.styleable.background_bl_checkable_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == 16842912 && index == R.styleable.background_bl_checked_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == 16842910 && index == R.styleable.background_bl_enabled_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == 16842913 && index == R.styleable.background_bl_selected_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == 16842919 && index == R.styleable.background_bl_pressed_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == 16842908 && index == R.styleable.background_bl_focused_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i25 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                }
            } else if (index == R.styleable.background_bl_padding_left) {
                rect.left = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_padding_top) {
                rect.top = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_padding_right) {
                rect.right = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_padding_bottom) {
                rect.bottom = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_size_width) {
                dimension = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_size_height) {
                dimension2 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_stroke_width) {
                dimension3 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_stroke_color) {
                color2 = this.typedArray.getColor(index, 0);
            } else if (index == R.styleable.background_bl_stroke_dashWidth) {
                dimension4 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_stroke_dashGap) {
                dimension5 = this.typedArray.getDimension(index, 0.0f);
            }
            i13++;
            i12 = 0;
        }
        if (hasSetRadius(fArr)) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_size_width) && this.typedArray.hasValue(R.styleable.background_bl_size_height)) {
            gradientDrawable.setSize((int) dimension, (int) dimension2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.typedArray.hasValue(R.styleable.background_bl_pressed_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_pressed));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_pressed_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unPressed_solid_color)) {
            arrayList.add(-16842919);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unPressed_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_checkable_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_checkable));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checkable_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unCheckable_solid_color)) {
            arrayList.add(-16842911);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unCheckable_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_checked_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_checked));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checked_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unChecked_solid_color)) {
            arrayList.add(-16842912);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unChecked_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_enabled_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_enabled));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_enabled_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unEnabled_solid_color)) {
            arrayList.add(-16842910);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unEnabled_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_selected_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_selected));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_selected_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unSelected_solid_color)) {
            arrayList.add(-16842913);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unSelected_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_focused_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_focused));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_focused_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unFocused_solid_color)) {
            arrayList.add(-16842908);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unFocused_solid_color, 0)));
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                size++;
            }
            int[][] iArr2 = new int[size][];
            int[] iArr3 = new int[size];
            Iterator it = arrayList.iterator();
            int i26 = 0;
            while (it.hasNext()) {
                iArr2[i26] = new int[]{((Integer) it.next()).intValue()};
                iArr3[i26] = ((Integer) arrayList2.get(i26)).intValue();
                i26++;
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                iArr2[i26] = new int[0];
                iArr3[i26] = color;
            }
            gradientDrawable.setColor(new ColorStateList(iArr2, iArr3));
        } else if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
            gradientDrawable.setColor(color);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_stroke_width)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (this.typedArray.hasValue(R.styleable.background_bl_pressed_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_pressed));
                arrayList3.add(-16842919);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_pressed_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unPressed_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_checkable_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_checkable));
                arrayList3.add(-16842911);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checkable_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unCheckable_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_checked_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_checked));
                arrayList3.add(-16842912);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checked_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unChecked_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_enabled_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_enabled));
                arrayList3.add(-16842910);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_enabled_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unEnabled_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_selected_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_selected));
                arrayList3.add(-16842913);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_selected_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unSelected_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_focused_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_focused));
                arrayList3.add(-16842908);
                i11 = 0;
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_focused_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unFocused_stroke_color, 0)));
            } else {
                i11 = 0;
            }
            if (arrayList3.size() > 0) {
                int[][] iArr4 = new int[arrayList3.size()][];
                int[] iArr5 = new int[arrayList3.size()];
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    iArr4[i11] = new int[]{((Integer) it2.next()).intValue()};
                    iArr5[i11] = ((Integer) arrayList4.get(i11)).intValue();
                    i11++;
                }
                gradientDrawable.setStroke((int) dimension3, new ColorStateList(iArr4, iArr5), dimension4, dimension5);
            } else if (this.typedArray.hasValue(R.styleable.background_bl_stroke_color)) {
                gradientDrawable.setStroke((int) dimension3, color2, dimension4, dimension5);
            }
        }
        if ((this.typedArray.hasValue(R.styleable.background_bl_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_centerY)) || (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_centerY)))))))) {
            gradientDrawable.setGradientCenter(f11, f12);
        }
        if ((this.typedArray.hasValue(R.styleable.background_bl_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_endColor)) || (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_endColor)))))))) {
            if (this.typedArray.hasValue(R.styleable.background_bl_gradient_centerColor)) {
                iArr = new int[]{color4, color3, color5};
            } else {
                iArr = new int[]{color4, color5};
            }
            gradientDrawable.setColors(iArr);
        }
        if (i14 == 0 && (this.typedArray.hasValue(R.styleable.background_bl_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_angle))) {
            int i27 = integer % 360;
            if (i27 % 45 != 0) {
                throw new XmlPullParserException(this.typedArray.getPositionDescription() + "<gradient> tag requires 'angle' attribute to be a multiple of 45");
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            if (i27 != 0) {
                if (i27 == 45) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                } else if (i27 == 90) {
                    orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                } else if (i27 == 135) {
                    orientation = GradientDrawable.Orientation.BR_TL;
                } else if (i27 == 180) {
                    orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                } else if (i27 == 225) {
                    orientation = GradientDrawable.Orientation.TR_BL;
                } else if (i27 == 270) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i27 == 315) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                }
            }
            gradientDrawable.setOrientation(orientation);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_padding_left) && this.typedArray.hasValue(R.styleable.background_bl_padding_top) && this.typedArray.hasValue(R.styleable.background_bl_padding_right) && this.typedArray.hasValue(R.styleable.background_bl_padding_bottom)) {
            if (Build.VERSION.SDK_INT >= 29) {
                gradientDrawable.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            } else {
                try {
                    Field declaredField = gradientDrawable.getClass().getDeclaredField("mPadding");
                    declaredField.setAccessible(true);
                    declaredField.set(gradientDrawable, rect);
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                } catch (NoSuchFieldException e12) {
                    e12.printStackTrace();
                }
            }
        }
        return gradientDrawable;
    }
}

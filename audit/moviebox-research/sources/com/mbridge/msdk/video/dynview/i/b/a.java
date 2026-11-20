package com.mbridge.msdk.video.dynview.i.b;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.mbridge.msdk.foundation.tools.ai;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(View view, float f11, float f12, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view == null || strArr == null) {
            return;
        }
        int[] iArr = new int[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            iArr[i11] = Color.parseColor(strArr[i11]);
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        gradientDrawable.setCornerRadius(ai.a(view.getContext(), f12));
        gradientDrawable.setStroke(ai.a(view.getContext(), f11), Color.parseColor(str));
        view.setBackground(gradientDrawable);
    }
}

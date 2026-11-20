package com.bytedance.sdk.component.adexpress.We;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    public static Drawable sc(Context context, int i11, int i12, int i13) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i11, i12);
        }
        gradientDrawable.setColor(i13);
        return gradientDrawable;
    }

    public static Drawable sc(Context context, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        if (context == null || qrVar == null) {
            return null;
        }
        return sc(context, (int) Qj.sc(context, qrVar.Xc()), qrVar.dE(), qrVar.McK());
    }
}

package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends c {
    public static float e(float f11) {
        return (float) (1.0d - Math.cos((((double) f11) * 3.141592653589793d) / 2.0d));
    }

    public static float f(float f11) {
        return (float) Math.sin((((double) f11) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.c
    public void d(TabLayout tabLayout, View view, View view2, float f11, @NonNull Drawable drawable) {
        float f12;
        float fE;
        RectF rectFA = c.a(tabLayout, view);
        RectF rectFA2 = c.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            f12 = e(f11);
            fE = f(f11);
        } else {
            f12 = f(f11);
            fE = e(f11);
        }
        drawable.setBounds(ii.b.c((int) rectFA.left, (int) rectFA2.left, f12), drawable.getBounds().top, ii.b.c((int) rectFA.right, (int) rectFA2.right, fE), drawable.getBounds().bottom);
    }
}

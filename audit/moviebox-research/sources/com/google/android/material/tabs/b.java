package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends c {
    @Override // com.google.android.material.tabs.c
    public void d(TabLayout tabLayout, View view, View view2, float f11, @NonNull Drawable drawable) {
        if (f11 >= 0.5f) {
            view = view2;
        }
        RectF rectFA = c.a(tabLayout, view);
        float fB = f11 < 0.5f ? ii.b.b(1.0f, 0.0f, 0.0f, 0.5f, f11) : ii.b.b(0.0f, 1.0f, 0.5f, 1.0f, f11);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (fB * 255.0f));
    }
}

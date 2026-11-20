package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ScreenAdapterLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f49585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49587d;

    public ScreenAdapterLayout(Context context) {
        super(context);
        this.f49584a = false;
        this.f49585b = false;
    }

    public ScreenAdapterLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49584a = false;
        this.f49585b = false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f49584a && !this.f49585b) {
            this.f49585b = true;
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                int i14 = layoutParams.width;
                if (i14 > 0) {
                    layoutParams.width = (int) (i14 * this.f49586c);
                    layoutParams.height = (int) (layoutParams.height * this.f49587d);
                }
                float f11 = layoutParams.topMargin;
                float f12 = this.f49587d;
                layoutParams.topMargin = (int) (f11 * f12);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * f12);
            }
            this.f49584a = false;
        }
        super.onMeasure(i11, i12);
    }

    public void setScale(float f11, float f12) {
        this.f49584a = true;
        this.f49586c = f11;
        this.f49587d = f12;
    }
}

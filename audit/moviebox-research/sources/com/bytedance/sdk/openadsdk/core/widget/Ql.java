package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql extends com.bytedance.sdk.openadsdk.core.ExN.We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f28535sc;

    public Ql(Context context) {
        this(context, null);
    }

    public Ql(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.We, android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int i13 = getLayoutParams().width;
        int i14 = getLayoutParams().height;
        float f11 = this.f28535sc;
        if (f11 > 0.0f) {
            if (i13 == -2) {
                size = (int) (size2 * f11);
                mode = 1073741824;
            } else if (i14 == -2) {
                size2 = (int) (size / f11);
                mode2 = 1073741824;
            }
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void setRatio(float f11) {
        this.f28535sc = f11;
    }
}

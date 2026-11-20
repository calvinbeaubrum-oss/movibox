package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1561Pj {
    public final int[] A00(View view, int i11, int i12) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i11, view.getPaddingLeft() + view.getPaddingRight(), c10624p.width), ViewGroup.getChildMeasureSpec(i12, view.getPaddingTop() + view.getPaddingBottom(), c10624p.height));
        return new int[]{view.getMeasuredWidth() + c10624p.leftMargin + c10624p.rightMargin, view.getMeasuredHeight() + c10624p.bottomMargin + c10624p.topMargin};
    }
}

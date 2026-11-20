package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NC extends ViewGroup {
    public static final int A01 = (int) (LD.A02 * 8.0f);
    public int A00;

    public NC(C1795Yn c1795Yn) {
        super(c1795Yn);
        setMotionEventSplittingEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (paddingLeft + measuredWidth > i15) {
                paddingLeft = getPaddingLeft();
                paddingTop += this.A00;
            }
            childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
            paddingLeft += A01 + measuredWidth;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i11, int i12) {
        int size = (View.MeasureSpec.getSize(i11) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i12) - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int iMax = 0;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        int i13 = getChildCount() > 0 ? 1 : 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i15 = A01;
            iMax = Math.max(iMax, measuredHeight + i15);
            if (paddingLeft + measuredWidth > size) {
                i13++;
                paddingLeft = getPaddingLeft();
            }
            paddingLeft += i15 + measuredWidth;
        }
        this.A00 = iMax;
        setMeasuredDimension(size, (i13 * iMax) + A01);
    }
}

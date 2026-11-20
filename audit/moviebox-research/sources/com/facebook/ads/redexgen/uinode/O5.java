package com.facebook.ads.redexgen.uinode;

import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O5 extends LinearLayout {
    public static final int A06 = (int) (LD.A02 * 4.0f);
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C1795Yn A04;
    public final O6[] A05;

    public O5(C1795Yn c1795Yn, int i11, int i12, int i13, int i14) {
        super(c1795Yn);
        this.A00 = A06;
        this.A04 = c1795Yn;
        setOrientation(0);
        this.A03 = i11;
        this.A01 = i13;
        this.A02 = i14;
        this.A05 = new O6[i12];
        for (int i15 = 0; i15 < i12; i15++) {
            this.A05[i15] = A00();
            addView(this.A05[i15]);
        }
        A01();
    }

    private O6 A00() {
        O6 o11 = new O6(this.A04, this.A01, this.A02);
        int i11 = this.A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        layoutParams.gravity = 16;
        o11.setLayoutParams(layoutParams);
        return o11;
    }

    private void A01() {
        int i11 = 0;
        while (true) {
            O6[] o6Arr = this.A05;
            if (i11 >= o6Arr.length) {
                requestLayout();
                return;
            } else {
                ((LinearLayout.LayoutParams) o6Arr[i11].getLayoutParams()).leftMargin = i11 == 0 ? 0 : this.A00;
                i11++;
            }
        }
    }

    private void A02(float f11) {
        for (int i11 = 0; i11 < this.A05.length; i11++) {
            float fMin = Math.min(1.0f, f11 - i11);
            if (fMin < 0.0f) {
                fMin = 0.0f;
            }
            this.A05[i11].setFillRatio(fMin);
        }
    }

    public void setItemSpacing(int i11) {
        this.A00 = i11;
        A01();
    }

    public void setRating(float f11) {
        A02(f11);
    }
}

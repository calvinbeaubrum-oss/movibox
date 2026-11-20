package com.facebook.ads.redexgen.uinode;

import android.text.Layout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WJ extends C1314Fn implements Comparable<WJ> {
    public final int A00;

    public WJ(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z11, int i14, int i15) {
        super(charSequence, alignment, f11, i11, i12, f12, i13, f13, z11, i14);
        this.A00 = i15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(WJ wj2) {
        int i11 = wj2.A00;
        int i12 = this.A00;
        if (i11 < i12) {
            return -1;
        }
        return i11 > i12 ? 1 : 0;
    }
}

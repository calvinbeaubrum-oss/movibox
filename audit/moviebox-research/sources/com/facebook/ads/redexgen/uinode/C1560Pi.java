package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1560Pi {
    public final SparseArray<int[]> A00 = new SparseArray<>();

    public final void A00(int i11, int[] iArr) {
        this.A00.put(i11, iArr);
    }

    public final boolean A01(int i11) {
        return this.A00.indexOfKey(i11) >= 0;
    }

    public final int[] A02(int i11) {
        return this.A00.get(i11);
    }
}

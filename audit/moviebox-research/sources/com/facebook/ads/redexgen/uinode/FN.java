package com.facebook.ads.redexgen.uinode;

import android.net.Uri;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FN {
    public final int A00;
    public final int[] A01;
    public final long[] A02;
    public final Uri[] A03;

    public FN() {
        this(-1, new int[0], new Uri[0], new long[0]);
    }

    public FN(int i11, int[] iArr, Uri[] uriArr, long[] jArr) {
        AbstractC1351Ha.A03(iArr.length == uriArr.length);
        this.A00 = i11;
        this.A01 = iArr;
        this.A03 = uriArr;
        this.A02 = jArr;
    }

    public final int A00() {
        return A01(-1);
    }

    public final int A01(int i11) {
        int i12;
        int i13 = i11 + 1;
        while (true) {
            int[] iArr = this.A01;
            if (i13 >= iArr.length || (i12 = iArr[i13]) == 0 || i12 == 1) {
                break;
            }
            i13++;
        }
        return i13;
    }

    public final boolean A02() {
        return this.A00 == -1 || A00() < this.A00;
    }
}

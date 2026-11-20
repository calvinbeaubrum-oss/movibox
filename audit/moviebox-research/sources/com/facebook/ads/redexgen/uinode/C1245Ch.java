package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ch, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1245Ch {
    public final int A00;
    public final int A01;
    public final long A02;
    public final C1242Ce A03;
    public final int[] A04;
    public final int[] A05;
    public final long[] A06;
    public final long[] A07;

    public C1245Ch(C1242Ce c1242Ce, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        AbstractC1351Ha.A03(iArr.length == jArr2.length);
        AbstractC1351Ha.A03(jArr.length == jArr2.length);
        AbstractC1351Ha.A03(iArr2.length == jArr2.length);
        this.A03 = c1242Ce;
        this.A06 = jArr;
        this.A05 = iArr;
        this.A00 = i11;
        this.A07 = jArr2;
        this.A04 = iArr2;
        this.A02 = j11;
        this.A01 = jArr.length;
    }

    public final int A00(long j11) {
        for (int iA0B = IF.A0B(this.A07, j11, true, false); iA0B >= 0; iA0B--) {
            if ((this.A04[iA0B] & 1) != 0) {
                return iA0B;
            }
        }
        return -1;
    }

    public final int A01(long j11) {
        for (int iA0A = IF.A0A(this.A07, j11, true, false); iA0A < this.A07.length; iA0A++) {
            if ((this.A04[iA0A] & 1) != 0) {
                return iA0A;
            }
        }
        return -1;
    }
}

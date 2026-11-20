package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ce, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1242Ce {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final Format A07;
    public final long[] A08;
    public final long[] A09;
    public final C1243Cf[] A0A;

    public C1242Ce(int i11, int i12, long j11, long j12, long j13, Format format, int i13, C1243Cf[] c1243CfArr, int i14, long[] jArr, long[] jArr2) {
        this.A00 = i11;
        this.A03 = i12;
        this.A06 = j11;
        this.A05 = j12;
        this.A04 = j13;
        this.A07 = format;
        this.A02 = i13;
        this.A0A = c1243CfArr;
        this.A01 = i14;
        this.A08 = jArr;
        this.A09 = jArr2;
    }

    public final C1243Cf A00(int i11) {
        C1243Cf[] c1243CfArr = this.A0A;
        if (c1243CfArr == null) {
            return null;
        }
        return c1243CfArr[i11];
    }
}

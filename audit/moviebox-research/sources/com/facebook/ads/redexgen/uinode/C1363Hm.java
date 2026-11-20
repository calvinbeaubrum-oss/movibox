package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1363Hm {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final long A07;

    public C1363Hm(byte[] bArr, int i11) {
        C1375Hy c1375Hy = new C1375Hy(bArr);
        c1375Hy.A07(i11 * 8);
        this.A04 = c1375Hy.A04(16);
        this.A02 = c1375Hy.A04(16);
        this.A05 = c1375Hy.A04(24);
        this.A03 = c1375Hy.A04(24);
        this.A06 = c1375Hy.A04(20);
        this.A01 = c1375Hy.A04(3) + 1;
        this.A00 = c1375Hy.A04(5) + 1;
        this.A07 = ((((long) c1375Hy.A04(4)) & 15) << 32) | (((long) c1375Hy.A04(32)) & 4294967295L);
    }

    public final int A00() {
        return this.A00 * this.A06;
    }

    public final long A01() {
        return (this.A07 * 1000000) / ((long) this.A06);
    }
}

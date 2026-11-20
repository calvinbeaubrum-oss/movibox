package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11829t {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final C1291Eo A04;
    public final boolean A05;
    public final boolean A06;

    public C11829t(C1291Eo c1291Eo, long j11, long j12, long j13, long j14, boolean z11, boolean z12) {
        this.A04 = c1291Eo;
        this.A03 = j11;
        this.A02 = j12;
        this.A00 = j13;
        this.A01 = j14;
        this.A06 = z11;
        this.A05 = z12;
    }

    public final C11829t A00(int i11) {
        return new C11829t(this.A04.A00(i11), this.A03, this.A02, this.A00, this.A01, this.A06, this.A05);
    }

    public final C11829t A01(long j11) {
        return new C11829t(this.A04, j11, this.A02, this.A00, this.A01, this.A06, this.A05);
    }
}

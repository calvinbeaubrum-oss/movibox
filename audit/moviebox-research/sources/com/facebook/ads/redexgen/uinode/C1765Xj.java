package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1765Xj implements C1 {
    public final long A00;
    public final C0 A01;

    public C1765Xj(long j11) {
        this(j11, 0L);
    }

    public C1765Xj(long j11, long j12) {
        this.A00 = j11;
        this.A01 = new C0(j12 == 0 ? C2.A03 : new C2(0L, j12));
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return false;
    }
}

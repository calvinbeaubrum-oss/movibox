package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F9 {
    public F9 A00;
    public C1337Gl A01;
    public boolean A02;
    public final long A03;
    public final long A04;

    public F9(long j11, int i11) {
        this.A04 = j11;
        this.A03 = ((long) i11) + j11;
    }

    public final int A00(long j11) {
        return ((int) (j11 - this.A04)) + this.A01.A00;
    }

    public final F9 A01() {
        this.A01 = null;
        F9 f11 = this.A00;
        this.A00 = null;
        return f11;
    }

    public final void A02(C1337Gl c1337Gl, F9 f11) {
        this.A01 = c1337Gl;
        this.A00 = f11;
        this.A02 = true;
    }
}

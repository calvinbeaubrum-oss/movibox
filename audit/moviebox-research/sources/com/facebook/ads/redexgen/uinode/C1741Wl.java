package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1741Wl implements C1 {
    public long A00;
    public long A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;

    public C1741Wl(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.A06 = i11;
        this.A07 = i12;
        this.A02 = i13;
        this.A04 = i14;
        this.A03 = i15;
        this.A05 = i16;
    }

    public final int A00() {
        return this.A07 * this.A03 * this.A06;
    }

    public final int A01() {
        return this.A04;
    }

    public final int A02() {
        return this.A05;
    }

    public final int A03() {
        return this.A06;
    }

    public final int A04() {
        return this.A07;
    }

    public final long A05(long j11) {
        return (1000000 * Math.max(0L, j11 - this.A01)) / ((long) this.A02);
    }

    public final void A06(long j11, long j12) {
        this.A01 = j11;
        this.A00 = j12;
    }

    public final boolean A07() {
        return (this.A01 == 0 || this.A00 == 0) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return (1000000 * (this.A00 / ((long) this.A04))) / ((long) this.A07);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        long j12 = (((long) this.A02) * j11) / 1000000;
        int i11 = this.A04;
        long jA0E = IF.A0E((j12 / ((long) i11)) * ((long) i11), 0L, this.A00 - ((long) i11));
        long j13 = this.A01 + jA0E;
        long jA05 = A05(j13);
        C2 c11 = new C2(jA05, j13);
        if (jA05 < j11) {
            long j14 = this.A00;
            int i12 = this.A04;
            if (jA0E != j14 - ((long) i12)) {
                long j15 = ((long) i12) + j13;
                return new C0(c11, new C2(A05(j15), j15));
            }
        }
        return new C0(c11);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return true;
    }
}

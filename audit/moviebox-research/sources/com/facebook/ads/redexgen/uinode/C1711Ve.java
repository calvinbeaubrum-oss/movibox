package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ve, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1711Ve implements InterfaceC1367Hq {
    public long A00;
    public long A01;
    public C11869x A02 = C11869x.A04;
    public boolean A03;
    public final InterfaceC1354Hd A04;

    public C1711Ve(InterfaceC1354Hd interfaceC1354Hd) {
        this.A04 = interfaceC1354Hd;
    }

    public final void A00() {
        if (this.A03) {
            return;
        }
        this.A00 = this.A04.A5T();
        this.A03 = true;
    }

    public final void A01() {
        if (this.A03) {
            A02(A7k());
            this.A03 = false;
        }
    }

    public final void A02(long j11) {
        this.A01 = j11;
        if (this.A03) {
            this.A00 = this.A04.A5T();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1367Hq
    public final C11869x A7h() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1367Hq
    public final long A7k() {
        long j11 = this.A01;
        if (!this.A03) {
            return j11;
        }
        long jA5T = this.A04.A5T() - this.A00;
        return this.A02.A01 == 1.0f ? j11 + C9W.A00(jA5T) : j11 + this.A02.A00(jA5T);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1367Hq
    public final C11869x AGA(C11869x c11869x) {
        if (this.A03) {
            A02(A7k());
        }
        this.A02 = c11869x;
        return c11869x;
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class XK implements C1 {
    public final /* synthetic */ XJ A00;

    public XK(XJ xj2) {
        this.A00 = xj2;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return this.A00.A0B.A03(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        if (j11 == 0) {
            return new C0(new C2(0L, this.A00.A09));
        }
        long jA04 = this.A00.A0B.A04(j11);
        XJ xj2 = this.A00;
        return new C0(new C2(j11, xj2.A00(xj2.A09, jA04, 30000L)));
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return true;
    }
}

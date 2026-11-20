package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XR implements CL {
    public final int A00;
    public final int A01;
    public final C1376Hz A02;

    public XR(XS xs2) {
        C1376Hz c1376Hz = xs2.A00;
        this.A02 = c1376Hz;
        c1376Hz.A0Y(12);
        this.A00 = c1376Hz.A0H();
        this.A01 = c1376Hz.A0H();
    }

    @Override // com.facebook.ads.redexgen.uinode.CL
    public final int A7o() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.CL
    public final boolean A93() {
        return this.A00 != 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.CL
    public final int AEN() {
        int i11 = this.A00;
        return i11 == 0 ? this.A02.A0H() : i11;
    }
}

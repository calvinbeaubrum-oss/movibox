package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZN extends KT {
    public final /* synthetic */ ZM A00;
    public final /* synthetic */ B0 A01;

    public ZN(ZM zm2, B0 b11) {
        this.A00 = zm2;
        this.A01 = b11;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        this.A01.setAdViewabilityChecker(this.A00.A02.A1A());
        this.A00.A02.A1c(true, true);
    }
}

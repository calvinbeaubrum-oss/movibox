package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1920bR extends KT {
    public final /* synthetic */ C1919bQ A00;
    public final /* synthetic */ B0 A01;

    public C1920bR(C1919bQ c1919bQ, B0 b11) {
        this.A00 = c1919bQ;
        this.A01 = b11;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        this.A00.A00.A0A();
        if (this.A00.A00.A0B != null) {
            this.A01.setAdViewabilityChecker(this.A00.A00.A0B);
            this.A00.A00.A0B.A0U();
        }
    }
}

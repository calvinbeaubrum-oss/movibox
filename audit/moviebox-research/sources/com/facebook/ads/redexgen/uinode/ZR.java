package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZR extends KG {
    public final /* synthetic */ ZQ A00;

    public ZR(ZQ zq2) {
        this.A00 = zq2;
    }

    @Override // com.facebook.ads.redexgen.uinode.KG
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            this.A00.A01.A06().onLoggingImpression(this.A00.A01.A07());
        }
    }
}

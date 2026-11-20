package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZD extends KG {
    public final /* synthetic */ ZA A00;
    public final /* synthetic */ C1401Jb A01;

    public ZD(ZA za2, C1401Jb c1401Jb) {
        this.A00 = za2;
        this.A01 = c1401Jb;
    }

    @Override // com.facebook.ads.redexgen.uinode.KG
    public final void A01() {
        if (this.A00.A00.A00() != null) {
            this.A00.A00.A00().onAdError(L1.A00(this.A01));
        }
    }
}

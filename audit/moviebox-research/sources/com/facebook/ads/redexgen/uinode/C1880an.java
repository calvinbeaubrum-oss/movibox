package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1880an extends KT {
    public final /* synthetic */ AbstractC1879am A00;
    public final /* synthetic */ C1401Jb A01;

    public C1880an(AbstractC1879am abstractC1879am, C1401Jb c1401Jb) {
        this.A00 = abstractC1879am;
        this.A01 = c1401Jb;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        this.A00.A0B.A0E().A4t(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A06 != null) {
            this.A00.A06.A0G(this.A01);
        }
    }
}

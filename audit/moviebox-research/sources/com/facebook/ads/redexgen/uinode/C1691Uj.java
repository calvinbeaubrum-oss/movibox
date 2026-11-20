package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1691Uj extends KT {
    public final /* synthetic */ L9 A00;

    public C1691Uj(L9 l11) {
        this.A00 = l11;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (this.A00.A05()) {
            this.A00.A02();
            this.A00.A05.postDelayed(this, this.A00.A02);
        }
    }
}

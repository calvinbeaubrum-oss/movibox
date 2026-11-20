package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SE extends KT {
    public final /* synthetic */ SA A00;

    public SE(SA sa2) {
        this.A00 = sa2;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (this.A00.A03) {
            return;
        }
        C11568r c11568r = this.A00.A0B;
        final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
        c11568r.A02(new AbstractC1573Pv(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.93
        });
        this.A00.A07.postDelayed(this, this.A00.A00);
    }
}

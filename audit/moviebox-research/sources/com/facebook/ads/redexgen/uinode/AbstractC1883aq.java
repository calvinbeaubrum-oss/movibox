package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1883aq implements C6U {
    public final boolean A00;

    public AbstractC1883aq(boolean z11) {
        this.A00 = z11;
    }

    public abstract void A00();

    public abstract void A01(boolean z11);

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void AB2() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C6U
    public final void ABB() {
        A01(true);
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class U3 implements NT {
    public final /* synthetic */ NJ A00;

    public U3(NJ nj2) {
        this.A00 = nj2;
    }

    @Override // com.facebook.ads.redexgen.uinode.NT
    public final void AAv(boolean z11) {
        if (!this.A00.A08 || this.A00.A00 == null) {
            return;
        }
        this.A00.A00.setEnabled(z11);
        this.A00.A00.setAlpha(z11 ? 1.0f : 0.3f);
    }

    @Override // com.facebook.ads.redexgen.uinode.NT
    public final void ABZ(boolean z11) {
        if (!this.A00.A08 || this.A00.A02 == null) {
            return;
        }
        this.A00.A02.setEnabled(z11);
        this.A00.A02.setAlpha(z11 ? 1.0f : 0.3f);
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EX extends O7 {
    public final /* synthetic */ C10795h A00;

    public EX(C10795h c10795h) {
        this.A00 = c10795h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(O8 o11) {
        if (this.A00.A08 != null) {
            V2.A0L(this.A00.A08.getInternalNativeAd()).A1c(true, true);
        }
        this.A00.A00.onPlayed();
    }
}

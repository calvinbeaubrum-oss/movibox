package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.au, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1887au implements InterfaceC09861q {
    public final /* synthetic */ C09781i A00;

    public C1887au(C09781i c09781i) {
        this.A00 = c09781i;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09861q
    public final void ACZ(AdError adError) {
        this.A00.A04.AAe(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09861q
    public final void ACa() {
        this.A00.A04.AAf();
    }
}

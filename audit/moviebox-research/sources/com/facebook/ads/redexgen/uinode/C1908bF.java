package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1908bF implements AnonymousClass61 {
    public final /* synthetic */ FY A00;

    public C1908bF(FY fy2) {
        this.A00 = fy2;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAl() {
        this.A00.A0C.set(true);
        this.A00.A01.ACy(this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAm() {
        this.A00.A01.AD1(this.A00, AdError.CACHE_ERROR);
    }
}

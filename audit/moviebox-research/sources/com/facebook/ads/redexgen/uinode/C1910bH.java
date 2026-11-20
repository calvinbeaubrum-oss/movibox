package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1910bH implements AnonymousClass61 {
    public final /* synthetic */ FY A00;
    public final /* synthetic */ boolean A01;

    public C1910bH(FY fy2, boolean z11) {
        this.A00 = fy2;
        this.A01 = z11;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAl() {
        if (C1384Ih.A1R(this.A00.A04) && this.A01) {
            FY fy2 = this.A00;
            fy2.A06 = PC.A01(fy2.A04, (FS) this.A00.A03, 0, new C1911bI(this));
        } else {
            this.A00.A0C.set(true);
            this.A00.A01.ACy(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAm() {
        this.A00.A01.AD1(this.A00, AdError.CACHE_ERROR);
    }
}

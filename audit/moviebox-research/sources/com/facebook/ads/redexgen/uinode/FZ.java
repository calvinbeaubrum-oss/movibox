package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FZ extends AbstractC1883aq {
    public final /* synthetic */ int A00;
    public final /* synthetic */ FY A01;
    public final /* synthetic */ C1896b3 A02;
    public final /* synthetic */ FS A03;
    public final /* synthetic */ C1795Yn A04;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FZ(FY fy2, boolean z11, C1795Yn c1795Yn, FS fs2, C1896b3 c1896b3, int i11) {
        super(z11);
        this.A01 = fy2;
        this.A04 = c1795Yn;
        this.A03 = fs2;
        this.A02 = c1896b3;
        this.A00 = i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1883aq
    public final void A00() {
        this.A01.A01.AD1(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1883aq
    public final void A01(boolean z11) {
        FY.A0D = null;
        if (z11) {
            this.A04.A00().AFq(this.A03.A12(), this.A02.A0w());
        }
        if (this.A00 == 0) {
            this.A01.A0C.set(true);
            this.A01.A01.ACy(this.A01);
        }
        this.A01.A0B(this.A04, this.A02, this.A00 + 1);
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1651Sv implements L8 {
    public final /* synthetic */ int A00;
    public final /* synthetic */ KT A01;
    public final /* synthetic */ AbstractC1648Ss A02;

    public C1651Sv(AbstractC1648Ss abstractC1648Ss, int i11, KT kt2) {
        this.A02 = abstractC1648Ss;
        this.A00 = i11;
        this.A01 = kt2;
    }

    @Override // com.facebook.ads.redexgen.uinode.L8
    public final void ABA() throws Throwable {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.uinode.L8
    public final void ACm(float f11) {
        this.A02.A07.setProgress(100.0f * (1.0f - (f11 / this.A00)));
    }
}

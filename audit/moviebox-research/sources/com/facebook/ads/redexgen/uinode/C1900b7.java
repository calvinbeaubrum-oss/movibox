package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1900b7 implements InterfaceC1507Nh {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC1899b6 A01;
    public final /* synthetic */ V2 A02;

    public C1900b7(AbstractC1899b6 abstractC1899b6, int i11, V2 v11) {
        this.A01 = abstractC1899b6;
        this.A00 = i11;
        this.A02 = v11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1507Nh
    public final void ABh(boolean z11) {
        if (this.A00 == 0) {
            this.A02.A1Z(this.A01.A04);
        }
        this.A02.A1c(z11, true);
    }
}

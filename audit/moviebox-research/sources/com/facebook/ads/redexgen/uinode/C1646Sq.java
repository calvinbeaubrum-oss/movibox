package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1646Sq implements InterfaceC1555Pd {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1644So A01;

    public C1646Sq(C1644So c1644So, int i11) {
        this.A01 = c1644So;
        this.A00 = i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void AAu() {
        this.A01.A0R(false, this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void ABH(int i11) {
        C1644So.A02(this.A01, i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void ABY(float f11) {
        if (this.A01.A08) {
            return;
        }
        this.A01.A0G(f11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void AD7(boolean z11) {
        this.A01.A0Q(z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void ADX(String str) {
        this.A01.A0D.A0E().A2z(str);
        this.A01.A0H.A43(this.A01.A0J.A6y());
        this.A01.A0H(3);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void AGq() {
        this.A01.A09 = false;
        this.A01.A0I.setProgressImmediate(0.0f);
        this.A01.A0I.setToolbarActionMode(2);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1555Pd
    public final void AGr(float f11) {
        this.A01.A0I.setProgress(100.0f * f11);
    }
}

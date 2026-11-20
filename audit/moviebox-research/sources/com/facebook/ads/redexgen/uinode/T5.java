package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class T5 implements L8 {
    public final /* synthetic */ T4 A00;

    public T5(T4 t11) {
        this.A00 = t11;
    }

    @Override // com.facebook.ads.redexgen.uinode.L8
    public final void ABA() {
        this.A00.A0F.ABH(this.A00.A0A);
        this.A00.A0F.AAu();
    }

    @Override // com.facebook.ads.redexgen.uinode.L8
    public final void ACm(float f11) {
        this.A00.A0F.AGr(((this.A00.A0A - f11) + (this.A00.A0V ? 0 : this.A00.A0I.getDuration())) / (this.A00.A0V ? this.A00.A0A : this.A00.A09));
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1666Tk extends KT {
    public final /* synthetic */ AbstractC1521Nv A00;

    public C1666Tk(AbstractC1521Nv abstractC1521Nv) {
        this.A00 = abstractC1521Nv;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (this.A00.isPressed()) {
            AbstractC1521Nv abstractC1521Nv = this.A00;
            abstractC1521Nv.postDelayed(this, abstractC1521Nv.A07);
        } else {
            this.A00.setPressed(true);
            AbstractC1521Nv abstractC1521Nv2 = this.A00;
            abstractC1521Nv2.postOnAnimationDelayed(abstractC1521Nv2.A09, 250L);
        }
    }
}

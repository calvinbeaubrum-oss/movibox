package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C8P extends O7 {
    public final /* synthetic */ LX A00;

    public C8P(LX lx2) {
        this.A00 = lx2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(O8 o11) {
        if (this.A00.A03 && this.A00.A02) {
            this.A00.A03 = false;
            if (this.A00.A0D(EnumC1586Qi.A04) || this.A00.A04) {
                this.A00.A04 = false;
                this.A00.A05.postDelayed(new C1460Lm(this), this.A00.A00);
            } else if (this.A00.A0D(EnumC1586Qi.A03)) {
                this.A00.A03();
                this.A00.A06(true, true);
            }
        }
    }
}

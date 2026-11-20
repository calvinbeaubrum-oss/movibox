package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C7T extends MX {
    public final /* synthetic */ L7 A00;

    public C7T(L7 l11) {
        this.A00 = l11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(MY my2) {
        if (this.A00.A01 != null && my2.A00().getAction() == 0) {
            this.A00.A04.removeCallbacksAndMessages(null);
            this.A00.A07(new QX(this));
        }
    }
}

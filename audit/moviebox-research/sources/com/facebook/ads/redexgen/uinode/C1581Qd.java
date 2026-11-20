package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1581Qd extends AbstractC11578s<C9H> {
    public final /* synthetic */ C9I A00;

    public C1581Qd(C9I c9i) {
        this.A00 = c9i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C9H c9h) {
        int iA00 = c9h.A00();
        int iA01 = c9h.A01();
        if (this.A00.A00 <= 0 || iA00 != iA01 || iA01 <= this.A00.A00) {
            if (iA01 >= iA00 + 500) {
                this.A00.A0e(iA00);
            } else if (iA01 != 0) {
                this.A00.A0e(iA01);
            } else {
                C9I c9i = this.A00;
                c9i.A0e(c9i.A00);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    public final Class<C9H> A01() {
        return C9H.class;
    }
}

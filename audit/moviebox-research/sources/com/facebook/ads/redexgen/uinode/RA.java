package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class RA extends AbstractC11578s<AnonymousClass93> {
    public final /* synthetic */ C9I A00;

    public RA(C9I c9i) {
        this.A00 = c9i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(AnonymousClass93 anonymousClass93) {
        int iA00 = anonymousClass93.A00();
        if (this.A00.A00 <= 0 || iA00 != this.A00.A0B.getDuration() || this.A00.A0B.getDuration() <= this.A00.A00) {
            this.A00.A0f(iA00);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    public final Class<AnonymousClass93> A01() {
        return AnonymousClass93.class;
    }
}

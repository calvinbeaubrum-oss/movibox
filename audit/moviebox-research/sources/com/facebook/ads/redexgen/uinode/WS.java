package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WS implements FB {
    public final int A00;
    public final /* synthetic */ CD A01;

    public WS(CD cd2, int i11) {
        this.A01 = cd2;
        this.A00 = i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final boolean A9C() {
        return this.A01.A0S(this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final void AAM() throws IOException {
        this.A01.A0Q();
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final int AEK(C11789p c11789p, C1773Xr c1773Xr, boolean z11) {
        return this.A01.A0P(this.A00, c11789p, c1773Xr, z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.FB
    public final int AGO(long j11) {
        return this.A01.A0O(this.A00, j11);
    }
}

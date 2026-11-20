package com.facebook.ads.redexgen.uinode;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WC implements InterfaceC1315Fo {
    public static final WC A01 = new WC();
    public final List<C1314Fn> A00;

    public WC() {
        this.A00 = Collections.emptyList();
    }

    public WC(C1314Fn c1314Fn) {
        this.A00 = Collections.singletonList(c1314Fn);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final List<C1314Fn> A6Z(long j11) {
        return j11 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final long A70(int i11) {
        AbstractC1351Ha.A03(i11 == 0);
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A71() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A7T(long j11) {
        return j11 < 0 ? 0 : -1;
    }
}

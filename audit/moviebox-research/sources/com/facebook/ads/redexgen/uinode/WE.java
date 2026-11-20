package com.facebook.ads.redexgen.uinode;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WE implements InterfaceC1315Fo {
    public final long[] A00;
    public final C1314Fn[] A01;

    public WE(C1314Fn[] c1314FnArr, long[] jArr) {
        this.A01 = c1314FnArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final List<C1314Fn> A6Z(long j11) {
        C1314Fn c1314Fn;
        int iA0B = IF.A0B(this.A00, j11, true, false);
        return (iA0B == -1 || (c1314Fn = this.A01[iA0B]) == null) ? Collections.emptyList() : Collections.singletonList(c1314Fn);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final long A70(int i11) {
        AbstractC1351Ha.A03(i11 >= 0);
        AbstractC1351Ha.A03(i11 < this.A00.length);
        return this.A00[i11];
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A71() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A7T(long j11) {
        int iA0A = IF.A0A(this.A00, j11, false, false);
        if (iA0A < this.A00.length) {
            return iA0A;
        }
        return -1;
    }
}

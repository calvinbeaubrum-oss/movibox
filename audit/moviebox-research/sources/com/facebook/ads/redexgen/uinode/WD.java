package com.facebook.ads.redexgen.uinode;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WD implements InterfaceC1315Fo {
    public final GB A00;
    public final Map<String, GH> A01;
    public final Map<String, GC> A02;
    public final long[] A03;

    public WD(GB gb2, Map<String, GH> map, Map<String, GC> map2) {
        this.A00 = gb2;
        this.A02 = map2;
        this.A01 = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.A03 = gb2.A0F();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final List<C1314Fn> A6Z(long j11) {
        return this.A00.A0D(j11, this.A01, this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final long A70(int i11) {
        return this.A03[i11];
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A71() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A7T(long j11) {
        int iA0A = IF.A0A(this.A03, j11, false, false);
        if (iA0A < this.A03.length) {
            return iA0A;
        }
        return -1;
    }
}

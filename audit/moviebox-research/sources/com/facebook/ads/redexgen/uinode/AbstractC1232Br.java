package com.facebook.ads.redexgen.uinode;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Br, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1232Br extends AbstractC1772Xq implements InterfaceC1315Fo {
    public long A00;
    public InterfaceC1315Fo A01;

    @Override // com.facebook.ads.redexgen.uinode.B7
    public final void A07() {
        super.A07();
        this.A01 = null;
    }

    public abstract void A08();

    public final void A09(long j11, InterfaceC1315Fo interfaceC1315Fo, long j12) {
        super.A01 = j11;
        this.A01 = interfaceC1315Fo;
        if (j12 == Long.MAX_VALUE) {
            j12 = super.A01;
        }
        this.A00 = j12;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final List<C1314Fn> A6Z(long j11) {
        return this.A01.A6Z(j11 - this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final long A70(int i11) {
        return this.A01.A70(i11) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A71() {
        return this.A01.A71();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A7T(long j11) {
        return this.A01.A7T(j11 - this.A00);
    }
}

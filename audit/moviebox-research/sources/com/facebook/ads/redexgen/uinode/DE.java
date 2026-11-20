package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DE {
    public final int A00;
    public final long A01;

    public DE(int i11, long j11) {
        this.A00 = i11;
        this.A01 = j11;
    }

    public static DE A00(InterfaceC1234Bt interfaceC1234Bt, C1376Hz c1376Hz) throws InterruptedException, IOException {
        interfaceC1234Bt.ADv(c1376Hz.A00, 0, 8);
        c1376Hz.A0Y(0);
        return new DE(c1376Hz.A08(), c1376Hz.A0K());
    }
}

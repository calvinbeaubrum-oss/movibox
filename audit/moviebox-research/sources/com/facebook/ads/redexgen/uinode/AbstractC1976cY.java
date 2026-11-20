package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1976cY {
    public InterfaceC1977cZ A00;

    public final void A00() {
        InterfaceC1977cZ interfaceC1977cZ = this.A00;
        if (interfaceC1977cZ != null) {
            interfaceC1977cZ.onStart();
        }
    }

    public final void A01() {
        InterfaceC1977cZ interfaceC1977cZ = this.A00;
        if (interfaceC1977cZ != null) {
            interfaceC1977cZ.onStop();
        }
    }

    public final void A02(InterfaceC1977cZ interfaceC1977cZ) {
        this.A00 = interfaceC1977cZ;
    }
}

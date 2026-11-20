package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Va, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1707Va implements InterfaceC1981cd<C1389Io, C1394It> {
    public VX A00;

    public C1707Va(VX vx2) {
        this.A00 = vx2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1981cd
    public final void A5c(C1978ca<C1389Io, C1394It> c1978ca, InterfaceC1968cP interfaceC1968cP) {
        switch (Im.A00[interfaceC1968cP.A8J(c1978ca).ordinal()]) {
            case 1:
            case 2:
                this.A00.A02(c1978ca, interfaceC1968cP);
                break;
        }
    }
}

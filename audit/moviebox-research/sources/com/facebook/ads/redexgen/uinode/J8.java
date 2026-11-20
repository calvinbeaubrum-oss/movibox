package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class J8 implements InterfaceC1624Ru {
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1624Ru
    public final long A4z() {
        return System.nanoTime();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1624Ru
    public final void AGQ(Object obj, long j11) throws InterruptedException {
        obj.wait(j11);
    }
}

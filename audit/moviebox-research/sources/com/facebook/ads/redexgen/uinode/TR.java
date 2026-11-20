package com.facebook.ads.redexgen.uinode;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TR implements InterfaceC1507Nh {
    public final WeakReference<B4> A00;

    public TR(B4 b11) {
        this.A00 = new WeakReference<>(b11);
    }

    public /* synthetic */ TR(B4 b11, BH bh2) {
        this(b11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1507Nh
    public final void ABh(boolean z11) {
        B4 b11 = this.A00.get();
        if (b11 != null) {
            b11.A06 = z11;
            b11.A04();
        }
    }
}

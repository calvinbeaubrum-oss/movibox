package com.facebook.ads.redexgen.uinode;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VF implements JK {
    public WeakReference<V2> A00;

    public VF(V2 v11) {
        this.A00 = new WeakReference<>(v11);
    }

    @Override // com.facebook.ads.redexgen.uinode.JK
    public final void ACX(boolean z11) {
        if (this.A00.get() != null) {
            this.A00.get().A1c(z11, false);
        }
    }
}

package com.facebook.ads.redexgen.uinode;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1676Tu extends KT {
    public final WeakReference<RE> A00;

    public C1676Tu(RE re2) {
        this.A00 = new WeakReference<>(re2);
    }

    public C1676Tu(WeakReference<RE> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        RE re2 = this.A00.get();
        if (re2 != null) {
            re2.A0U();
        }
    }
}

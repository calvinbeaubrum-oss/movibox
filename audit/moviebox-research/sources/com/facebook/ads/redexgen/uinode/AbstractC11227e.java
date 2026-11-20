package com.facebook.ads.redexgen.uinode;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC11227e {
    public static final AtomicReference<C1794Ym> A00 = new AtomicReference<>();

    public static C1794Ym A00() {
        return A00.get();
    }

    public static void A01(C1794Ym c1794Ym) {
        if (c1794Ym == null) {
            return;
        }
        AbstractC11217d.A00(A00, null, c1794Ym);
    }
}

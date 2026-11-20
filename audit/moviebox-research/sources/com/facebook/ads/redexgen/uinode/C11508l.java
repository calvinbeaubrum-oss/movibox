package com.facebook.ads.redexgen.uinode;

import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11508l {
    public static C11508l A00 = new C11508l();

    public static C11508l A00() {
        return A00;
    }

    public final YI A01(C11237f c11237f, boolean z11) {
        return new YI(c11237f, z11, new C6S());
    }

    public final Map<String, String> A02(C11237f c11237f) {
        try {
            return A01(c11237f, false).A05();
        } catch (Throwable th2) {
            c11237f.A07().A3c(th2);
            return C11428d.A01(c11237f);
        }
    }
}

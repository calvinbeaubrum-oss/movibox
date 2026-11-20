package com.facebook.ads.redexgen.uinode;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M2 {
    public static M2 A02;
    public final UY A00;
    public final M4 A01;

    public M2(C1795Yn c1795Yn, Executor executor, C8S c8s) {
        this.A01 = new M4(c1795Yn);
        this.A00 = new UY(executor, c8s, c1795Yn);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C1795Yn c1795Yn, Executor executor, C8S c8s) {
        if (C1384Ih.A1C(c1795Yn)) {
            M2 m11 = A02;
            if (m11 != null) {
                m11.A02(c8s);
                return;
            }
            M2 m12 = new M2(c1795Yn, executor, c8s);
            A02 = m12;
            m12.A00();
        }
    }

    private void A02(C8S c8s) {
        this.A00.A07(c8s);
    }
}

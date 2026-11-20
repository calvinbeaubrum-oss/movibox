package com.facebook.ads.redexgen.uinode;

import android.view.Surface;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ia, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1377Ia implements Runnable {
    public final /* synthetic */ Surface A00;
    public final /* synthetic */ C1379Ic A01;

    public RunnableC1377Ia(C1379Ic c1379Ic, Surface surface) {
        this.A01 = c1379Ic;
        this.A00 = surface;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.ACt(this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

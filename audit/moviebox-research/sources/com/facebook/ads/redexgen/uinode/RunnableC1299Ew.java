package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1299Ew implements Runnable {
    public final /* synthetic */ F1 A00;
    public final /* synthetic */ F2 A01;
    public final /* synthetic */ F3 A02;
    public final /* synthetic */ F4 A03;
    public final /* synthetic */ IOException A04;
    public final /* synthetic */ boolean A05;

    public RunnableC1299Ew(F1 f11, F4 f12, F2 f13, F3 f14, IOException iOException, boolean z11) {
        this.A00 = f11;
        this.A03 = f12;
        this.A01 = f13;
        this.A02 = f14;
        this.A04 = iOException;
        this.A05 = z11;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.AC3(this.A00.A00, this.A00.A01, this.A01, this.A02, this.A04, this.A05);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

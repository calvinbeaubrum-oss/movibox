package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ez, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1302Ez implements Runnable {
    public final /* synthetic */ F1 A00;
    public final /* synthetic */ F3 A01;
    public final /* synthetic */ F4 A02;

    public RunnableC1302Ez(F1 f11, F4 f12, F3 f13) {
        this.A00 = f11;
        this.A02 = f12;
        this.A01 = f13;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A02.ABM(this.A00.A00, this.A00.A01, this.A01);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1300Ex implements Runnable {
    public final /* synthetic */ F1 A00;
    public final /* synthetic */ F4 A01;

    public RunnableC1300Ex(F1 f11, F4 f12) {
        this.A00 = f11;
        this.A01 = f12;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.ACp(this.A00.A00, this.A00.A01);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

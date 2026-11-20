package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1297Eu implements Runnable {
    public final /* synthetic */ F1 A00;
    public final /* synthetic */ F2 A01;
    public final /* synthetic */ F3 A02;
    public final /* synthetic */ F4 A03;

    public RunnableC1297Eu(F1 f11, F4 f12, F2 f13, F3 f14) {
        this.A00 = f11;
        this.A03 = f12;
        this.A01 = f13;
        this.A02 = f14;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.AC0(this.A00.A00, this.A00.A01, this.A01, this.A02);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1378Ib implements Runnable {
    public final /* synthetic */ BC A00;
    public final /* synthetic */ C1379Ic A01;

    public RunnableC1378Ib(C1379Ic c1379Ic, BC bc2) {
        this.A01 = c1379Ic;
        this.A00 = bc2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A00();
            this.A01.A01.ADV(this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

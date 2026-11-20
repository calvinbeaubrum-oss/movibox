package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ac, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1191Ac implements Runnable {
    public final /* synthetic */ C1197Ai A00;
    public final /* synthetic */ BC A01;

    public RunnableC1191Ac(C1197Ai c1197Ai, BC bc2) {
        this.A00 = c1197Ai;
        this.A01 = bc2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A01.AAq(this.A01);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

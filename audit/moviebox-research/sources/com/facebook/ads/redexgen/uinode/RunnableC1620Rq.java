package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1620Rq implements Runnable {
    public final /* synthetic */ C1362Hl A00;

    public RunnableC1620Rq(C1362Hl c1362Hl) {
        this.A00 = c1362Hl;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            C1362Hl.A03(this.A00);
            throw null;
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

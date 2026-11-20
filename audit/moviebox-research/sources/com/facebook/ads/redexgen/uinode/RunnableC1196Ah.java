package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1196Ah implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1197Ai A01;

    public RunnableC1196Ah(C1197Ai c1197Ai, int i11) {
        this.A01 = c1197Ai;
        this.A00 = i11;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.AAs(this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

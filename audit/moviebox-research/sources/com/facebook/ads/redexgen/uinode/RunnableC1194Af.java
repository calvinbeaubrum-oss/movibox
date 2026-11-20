package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Af, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1194Af implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ C1197Ai A03;

    public RunnableC1194Af(C1197Ai c1197Ai, int i11, long j11, long j12) {
        this.A03 = c1197Ai;
        this.A00 = i11;
        this.A01 = j11;
        this.A02 = j12;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.A01.AAt(this.A00, this.A01, this.A02);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

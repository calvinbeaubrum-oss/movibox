package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Gz implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ W1 A03;

    public Gz(W1 w11, int i11, long j11, long j12) {
        this.A03 = w11;
        this.A00 = i11;
        this.A02 = j11;
        this.A01 = j12;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A03.A07.AAw(this.A00, this.A02, this.A01);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

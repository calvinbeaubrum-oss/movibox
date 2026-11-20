package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PZ implements Runnable {
    public final /* synthetic */ C1653Sx A00;

    public PZ(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0K) {
                this.A00.A0Q();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

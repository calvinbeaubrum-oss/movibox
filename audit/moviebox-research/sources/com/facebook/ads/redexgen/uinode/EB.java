package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EB implements Runnable {
    public final /* synthetic */ ED A00;
    public final /* synthetic */ Throwable A01;

    public EB(ED ed2, Throwable th2) {
        this.A00 = ed2;
        this.A01 = th2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            ED ed2 = this.A00;
            Throwable th2 = this.A01;
            if (!ed2.A0G(1, th2 != null ? 4 : 2, th2) && !this.A00.A0F(6, 3) && !this.A00.A0F(7, 0)) {
                throw new IllegalStateException();
            }
        } catch (Throwable th3) {
            KL.A00(th3, this);
        }
    }
}

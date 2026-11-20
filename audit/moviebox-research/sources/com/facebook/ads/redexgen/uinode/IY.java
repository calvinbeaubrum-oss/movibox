package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IY implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C1379Ic A02;

    public IY(C1379Ic c1379Ic, int i11, long j11) {
        this.A02 = c1379Ic;
        this.A00 = i11;
        this.A01 = j11;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A02.A01.ABN(this.A00, this.A01);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

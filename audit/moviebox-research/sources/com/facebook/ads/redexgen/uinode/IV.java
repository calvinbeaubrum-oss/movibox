package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IV implements Runnable {
    public final /* synthetic */ BC A00;
    public final /* synthetic */ C1379Ic A01;

    public IV(C1379Ic c1379Ic, BC bc2) {
        this.A01 = c1379Ic;
        this.A00 = bc2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.ADW(this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NZ implements Runnable {
    public final /* synthetic */ C1500Na A00;
    public final /* synthetic */ InterfaceC1501Nb A01;

    public NZ(C1500Na c1500Na, InterfaceC1501Nb interfaceC1501Nb) {
        this.A00 = c1500Na;
        this.A01 = interfaceC1501Nb;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.AAn();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IW implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ C1379Ic A02;
    public final /* synthetic */ String A03;

    public IW(C1379Ic c1379Ic, String str, long j11, long j12) {
        this.A02 = c1379Ic;
        this.A03 = str;
        this.A01 = j11;
        this.A00 = j12;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A02.A01.ADU(this.A03, this.A01, this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IZ implements Runnable {
    public final /* synthetic */ float A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ int A03;
    public final /* synthetic */ C1379Ic A04;

    public IZ(C1379Ic c1379Ic, int i11, int i12, int i13, float f11) {
        this.A04 = c1379Ic;
        this.A03 = i11;
        this.A01 = i12;
        this.A02 = i13;
        this.A00 = f11;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A04.A01.ADf(this.A03, this.A01, this.A02, this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

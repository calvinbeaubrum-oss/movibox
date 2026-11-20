package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IX implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ C1379Ic A01;

    public IX(C1379Ic c1379Ic, Format format) {
        this.A01 = c1379Ic;
        this.A00 = format;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01.ADa(this.A00);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

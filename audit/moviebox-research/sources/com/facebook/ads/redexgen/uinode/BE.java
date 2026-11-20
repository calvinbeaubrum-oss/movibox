package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class BE extends Thread {
    public final /* synthetic */ AbstractC1771Xp A00;

    public BE(AbstractC1771Xp abstractC1771Xp) {
        this.A00 = abstractC1771Xp;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0M();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

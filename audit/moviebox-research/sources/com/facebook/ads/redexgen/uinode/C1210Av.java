package com.facebook.ads.redexgen.uinode;

import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Av, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1210Av extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ C1780Xy A01;

    public C1210Av(C1780Xy c1780Xy, AudioTrack audioTrack) {
        this.A01 = c1780Xy;
        this.A00 = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                this.A00.flush();
                this.A00.release();
            } finally {
                this.A01.A0f.open();
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

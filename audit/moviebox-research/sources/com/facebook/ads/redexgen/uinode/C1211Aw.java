package com.facebook.ads.redexgen.uinode;

import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1211Aw extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ C1780Xy A01;

    public C1211Aw(C1780Xy c1780Xy, AudioTrack audioTrack) {
        this.A01 = c1780Xy;
        this.A00 = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.release();
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

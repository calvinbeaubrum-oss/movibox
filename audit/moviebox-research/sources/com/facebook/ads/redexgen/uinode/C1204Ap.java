package com.facebook.ads.redexgen.uinode;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1204Ap {
    public long A00;
    public long A01;
    public long A02;
    public final AudioTimestamp A03 = new AudioTimestamp();
    public final AudioTrack A04;

    public C1204Ap(AudioTrack audioTrack) {
        this.A04 = audioTrack;
    }

    public final long A00() {
        return this.A00;
    }

    public final long A01() {
        return this.A03.nanoTime / 1000;
    }

    public final boolean A02() {
        boolean timestamp = this.A04.getTimestamp(this.A03);
        if (timestamp) {
            long j11 = this.A03.framePosition;
            if (this.A01 > j11) {
                this.A02++;
            }
            this.A01 = j11;
            this.A00 = (this.A02 << 32) + j11;
        }
        return timestamp;
    }
}

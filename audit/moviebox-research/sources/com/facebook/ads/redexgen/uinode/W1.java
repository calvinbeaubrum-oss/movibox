package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W1 implements InterfaceC1341Gp, HG<Object> {
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public final Handler A06;
    public final InterfaceC1340Go A07;
    public final InterfaceC1354Hd A08;
    public final IA A09;

    public W1() {
        this(null, null, 1000000L, 2000, InterfaceC1354Hd.A00);
    }

    public W1(Handler handler, InterfaceC1340Go interfaceC1340Go, long j11, int i11, InterfaceC1354Hd interfaceC1354Hd) {
        this.A06 = handler;
        this.A07 = interfaceC1340Go;
        this.A09 = new IA(i11);
        this.A08 = interfaceC1354Hd;
        this.A01 = j11;
    }

    private void A01(int i11, long j11, long j12) {
        Handler handler = this.A06;
        if (handler == null || this.A07 == null) {
            return;
        }
        handler.post(new Gz(this, i11, j11, j12));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1341Gp
    public final synchronized long A67() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.HG
    public final synchronized void AB1(Object obj, int i11) {
        this.A02 += (long) i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.HG
    public final synchronized void ADO(Object obj) {
        AbstractC1351Ha.A04(this.A00 > 0);
        long jA5T = this.A08.A5T();
        int i11 = (int) (jA5T - this.A03);
        this.A05 += (long) i11;
        long j11 = this.A04;
        long j12 = this.A02;
        this.A04 = j11 + j12;
        if (i11 > 0) {
            this.A09.A03((int) Math.sqrt(j12), (8000 * j12) / ((long) i11));
            if (this.A05 >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS || this.A04 >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                this.A01 = (long) this.A09.A02(0.5f);
            }
        }
        A01(i11, this.A02, this.A01);
        int i12 = this.A00 - 1;
        this.A00 = i12;
        if (i12 > 0) {
            this.A03 = jA5T;
        }
        this.A02 = 0L;
    }

    @Override // com.facebook.ads.redexgen.uinode.HG
    public final synchronized void ADP(Object obj, C1350Gy c1350Gy) {
        if (this.A00 == 0) {
            this.A03 = this.A08.A5T();
        }
        this.A00++;
    }
}

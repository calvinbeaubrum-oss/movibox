package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EF {
    public final float A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final DownloadAction A04;
    public final Throwable A05;

    public EF(int i11, DownloadAction downloadAction, int i12, float f11, long j11, Throwable th2) {
        this.A02 = i11;
        this.A04 = downloadAction;
        this.A01 = i12;
        this.A00 = f11;
        this.A03 = j11;
        this.A05 = th2;
    }

    public /* synthetic */ EF(int i11, DownloadAction downloadAction, int i12, float f11, long j11, Throwable th2, E5 e11) {
        this(i11, downloadAction, i12, f11, j11, th2);
    }
}

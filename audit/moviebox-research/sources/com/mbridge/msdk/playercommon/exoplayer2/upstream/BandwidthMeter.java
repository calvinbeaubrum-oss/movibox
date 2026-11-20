package com.mbridge.msdk.playercommon.exoplayer2.upstream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface BandwidthMeter {

    /* JADX INFO: compiled from: source.java */
    public interface EventListener {
        void onBandwidthSample(int i11, long j11, long j12);
    }

    long getBitrateEstimate();
}

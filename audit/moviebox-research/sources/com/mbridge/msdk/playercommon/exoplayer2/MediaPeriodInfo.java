package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f46511id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12, long j13, long j14, boolean z11, boolean z12) {
        this.f46511id = mediaPeriodId;
        this.startPositionUs = j11;
        this.endPositionUs = j12;
        this.contentPositionUs = j13;
        this.durationUs = j14;
        this.isLastInTimelinePeriod = z11;
        this.isFinal = z12;
    }

    public final MediaPeriodInfo copyWithPeriodIndex(int i11) {
        return new MediaPeriodInfo(this.f46511id.copyWithPeriodIndex(i11), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public final MediaPeriodInfo copyWithStartPositionUs(long j11) {
        return new MediaPeriodInfo(this.f46511id, j11, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}

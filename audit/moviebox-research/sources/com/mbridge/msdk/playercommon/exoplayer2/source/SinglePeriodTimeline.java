package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class SinglePeriodTimeline extends Timeline {
    private static final Object UID = new Object();
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    public SinglePeriodTimeline(long j11, long j12, long j13, long j14, long j15, long j16, boolean z11, boolean z12, Object obj) {
        this.presentationStartTimeMs = j11;
        this.windowStartTimeMs = j12;
        this.periodDurationUs = j13;
        this.windowDurationUs = j14;
        this.windowPositionInPeriodUs = j15;
        this.windowDefaultStartPositionUs = j16;
        this.isSeekable = z11;
        this.isDynamic = z12;
        this.tag = obj;
    }

    public SinglePeriodTimeline(long j11, long j12, long j13, long j14, boolean z11, boolean z12, Object obj) {
        this(C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z11, z12, obj);
    }

    public SinglePeriodTimeline(long j11, boolean z11, boolean z12) {
        this(j11, z11, z12, null);
    }

    public SinglePeriodTimeline(long j11, boolean z11, boolean z12, Object obj) {
        this(j11, j11, 0L, 0L, z11, z12, obj);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        return UID.equals(obj) ? 0 : -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
        Assertions.checkIndex(i11, 0, 1);
        return period.set(null, z11 ? UID : null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final int getPeriodCount() {
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[PHI: r1
  0x0031: PHI (r1v4 long) = (r1v3 long), (r1v3 long), (r1v7 long) binds: [B:8:0x0015, B:10:0x001b, B:15:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i11, Timeline.Window window, boolean z11, long j11) {
        long j12;
        Assertions.checkIndex(i11, 0, 1);
        Object obj = z11 ? this.tag : null;
        long j13 = this.windowDefaultStartPositionUs;
        boolean z12 = this.isDynamic;
        if (!z12 || j11 == 0) {
            j12 = j13;
        } else {
            long j14 = this.windowDurationUs;
            if (j14 != C.TIME_UNSET) {
                j13 += j11;
                if (j13 <= j14) {
                    j12 = j13;
                }
            }
            j12 = -9223372036854775807L;
        }
        return window.set(obj, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z12, j12, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final int getWindowCount() {
        return 1;
    }
}

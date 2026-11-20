package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.applovin.sdk.AppLovinMediationProvider;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class ClippingMediaSource extends CompositeMediaSource<Void> {
    private final boolean allowDynamicClippingUpdates;
    private IllegalClippingException clippingError;
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private Object manifest;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private final MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline.Window window;

    /* JADX INFO: compiled from: source.java */
    public static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long j11, long j12) throws IllegalClippingException {
            super(timeline);
            boolean z11 = false;
            if (timeline.getPeriodCount() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window(), false);
            long jMax = Math.max(0L, j11);
            long jMax2 = j12 == Long.MIN_VALUE ? window.durationUs : Math.max(0L, j12);
            long j13 = window.durationUs;
            if (j13 != C.TIME_UNSET) {
                jMax2 = jMax2 > j13 ? j13 : jMax2;
                if (jMax != 0 && !window.isSeekable) {
                    throw new IllegalClippingException(1);
                }
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.startUs = jMax;
            this.endUs = jMax2;
            this.durationUs = jMax2 == C.TIME_UNSET ? -9223372036854775807L : jMax2 - jMax;
            if (window.isDynamic && (jMax2 == C.TIME_UNSET || (j13 != C.TIME_UNSET && jMax2 == j13))) {
                z11 = true;
            }
            this.isDynamic = z11;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.source.ForwardingTimeline, com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            this.timeline.getPeriod(0, period, z11);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long j11 = this.durationUs;
            return period.set(period.f46512id, period.uid, 0, j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - positionInWindowUs, positionInWindowUs);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.source.ForwardingTimeline, com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final Timeline.Window getWindow(int i11, Timeline.Window window, boolean z11, long j11) {
            this.timeline.getWindow(0, window, z11, 0L);
            long j12 = window.positionInFirstPeriodUs;
            long j13 = this.startUs;
            window.positionInFirstPeriodUs = j12 + j13;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            long j14 = window.defaultPositionUs;
            if (j14 != C.TIME_UNSET) {
                long jMax = Math.max(j14, j13);
                window.defaultPositionUs = jMax;
                long j15 = this.endUs;
                if (j15 != C.TIME_UNSET) {
                    jMax = Math.min(jMax, j15);
                }
                window.defaultPositionUs = jMax - this.startUs;
            }
            long jUsToMs = C.usToMs(this.startUs);
            long j16 = window.presentationStartTimeMs;
            if (j16 != C.TIME_UNSET) {
                window.presentationStartTimeMs = j16 + jUsToMs;
            }
            long j17 = window.windowStartTimeMs;
            if (j17 != C.TIME_UNSET) {
                window.windowStartTimeMs = j17 + jUsToMs;
            }
            return window;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        /* JADX INFO: compiled from: source.java */
        public @interface Reason {
        }

        public IllegalClippingException(int i11) {
            super("Illegal clipping: " + getReasonDescription(i11));
            this.reason = i11;
        }

        private static String getReasonDescription(int i11) {
            if (i11 == 0) {
                return "invalid period count";
            }
            if (i11 != 1) {
                return i11 != 2 ? AppLovinMediationProvider.UNKNOWN : "start exceeds end";
            }
            return "not seekable to start";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11) {
        this(mediaSource, 0L, j11, true, false, true);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11, long j12) {
        this(mediaSource, j11, j12, true, false, false);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11, long j12, boolean z11) {
        this(mediaSource, j11, j12, z11, false, false);
    }

    public ClippingMediaSource(MediaSource mediaSource, long j11, long j12, boolean z11, boolean z12, boolean z13) {
        Assertions.checkArgument(j11 >= 0);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.startUs = j11;
        this.endUs = j12;
        this.enableInitialDiscontinuity = z11;
        this.allowDynamicClippingUpdates = z12;
        this.relativeToDefaultPosition = z13;
        this.mediaPeriods = new ArrayList<>();
        this.window = new Timeline.Window();
    }

    private void refreshClippedTimeline(Timeline timeline) {
        long j11;
        long j12;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long j13 = this.startUs;
            long j14 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j13 += defaultPositionUs;
                j14 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j13;
            this.periodEndUs = this.endUs != Long.MIN_VALUE ? positionInFirstPeriodUs + j14 : Long.MIN_VALUE;
            int size = this.mediaPeriods.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mediaPeriods.get(i11).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.periodStartUs - positionInFirstPeriodUs;
            j12 = this.endUs != Long.MIN_VALUE ? this.periodEndUs - positionInFirstPeriodUs : Long.MIN_VALUE;
            j11 = j15;
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(timeline, j11, j12);
            this.clippingTimeline = clippingTimeline;
            refreshSourceInfo(clippingTimeline, this.manifest);
        } catch (IllegalClippingException e11) {
            this.clippingError = e11;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource
    public final long getMediaTimeForChildMediaTime(Void r11, long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long jUsToMs = C.usToMs(this.startUs);
        long jMax = Math.max(0L, j11 - jUsToMs);
        long j12 = this.endUs;
        return j12 != Long.MIN_VALUE ? Math.min(C.usToMs(j12) - jUsToMs, jMax) : jMax;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource, com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource
    public final void onChildSourceInfoRefreshed(Void r11, MediaSource mediaSource, Timeline timeline, Object obj) {
        if (this.clippingError != null) {
            return;
        }
        this.manifest = obj;
        refreshClippedTimeline(timeline);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource, com.mbridge.msdk.playercommon.exoplayer2.source.BaseMediaSource
    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z11) {
        super.prepareSourceInternal(exoPlayer, z11);
        prepareChildSource(null, this.mediaSource);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (!this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            return;
        }
        refreshClippedTimeline(this.clippingTimeline.timeline);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource, com.mbridge.msdk.playercommon.exoplayer2.source.BaseMediaSource
    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }
}

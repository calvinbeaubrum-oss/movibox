package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdPlaybackState;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() { // from class: com.mbridge.msdk.playercommon.exoplayer2.Timeline.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final Period getPeriod(int i11, Period period, boolean z11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final int getPeriodCount() {
            return 0;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final Window getWindow(int i11, Window window, boolean z11, long j11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final int getWindowCount() {
            return 0;
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Object f46512id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public final int getAdCountInAdGroup(int i11) {
            return this.adPlaybackState.adGroups[i11].count;
        }

        public final long getAdDurationUs(int i11, int i12) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i11];
            return adGroup.count != -1 ? adGroup.durationsUs[i12] : C.TIME_UNSET;
        }

        public final int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public final int getAdGroupIndexAfterPositionUs(long j11) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j11);
        }

        public final int getAdGroupIndexForPositionUs(long j11) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j11);
        }

        public final long getAdGroupTimeUs(int i11) {
            return this.adPlaybackState.adGroupTimesUs[i11];
        }

        public final long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final int getFirstAdIndexToPlay(int i11) {
            return this.adPlaybackState.adGroups[i11].getFirstAdIndexToPlay();
        }

        public final int getNextAdIndexToPlay(int i11, int i12) {
            return this.adPlaybackState.adGroups[i11].getNextAdIndexToPlay(i12);
        }

        public final long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public final long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public final boolean hasPlayedAdGroup(int i11) {
            return !this.adPlaybackState.adGroups[i11].hasUnplayedAds();
        }

        public final boolean isAdAvailable(int i11, int i12) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i11];
            return (adGroup.count == -1 || adGroup.states[i12] == 0) ? false : true;
        }

        public final Period set(Object obj, Object obj2, int i11, long j11, long j12) {
            return set(obj, obj2, i11, j11, j12, AdPlaybackState.NONE);
        }

        public final Period set(Object obj, Object obj2, int i11, long j11, long j12, AdPlaybackState adPlaybackState) {
            this.f46512id = obj;
            this.uid = obj2;
            this.windowIndex = i11;
            this.durationUs = j11;
            this.positionInWindowUs = j12;
            this.adPlaybackState = adPlaybackState;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public Object tag;
        public long windowStartTimeMs;

        public final long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public final long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public final long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public final Window set(Object obj, long j11, long j12, boolean z11, boolean z12, long j13, long j14, int i11, int i12, long j15) {
            this.tag = obj;
            this.presentationStartTimeMs = j11;
            this.windowStartTimeMs = j12;
            this.isSeekable = z11;
            this.isDynamic = z12;
            this.defaultPositionUs = j13;
            this.durationUs = j14;
            this.firstPeriodIndex = i11;
            this.lastPeriodIndex = i12;
            this.positionInFirstPeriodUs = j15;
            return this;
        }
    }

    public int getFirstWindowIndex(boolean z11) {
        return isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z11) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i11, Period period, Window window, int i12, boolean z11) {
        int i13 = getPeriod(i11, period).windowIndex;
        if (getWindow(i13, window).lastPeriodIndex != i11) {
            return i11 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i13, i12, z11);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == getLastWindowIndex(z11)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == getLastWindowIndex(z11) ? getFirstWindowIndex(z11) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public final Period getPeriod(int i11, Period period) {
        return getPeriod(i11, period, false);
    }

    public abstract Period getPeriod(int i11, Period period, boolean z11);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i11, long j11) {
        return getPeriodPosition(window, period, i11, j11, 0L);
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i11, long j11, long j12) {
        Assertions.checkIndex(i11, 0, getWindowCount());
        getWindow(i11, window, false, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = window.getDefaultPositionUs();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j11;
        long durationUs = getPeriod(i12, period).getDurationUs();
        while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i12 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i12++;
            durationUs = getPeriod(i12, period).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i12), Long.valueOf(positionInFirstPeriodUs));
    }

    public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
        if (i12 == 0) {
            if (i11 == getFirstWindowIndex(z11)) {
                return -1;
            }
            return i11 - 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == getFirstWindowIndex(z11) ? getLastWindowIndex(z11) : i11 - 1;
        }
        throw new IllegalStateException();
    }

    public final Window getWindow(int i11, Window window) {
        return getWindow(i11, window, false);
    }

    public final Window getWindow(int i11, Window window, boolean z11) {
        return getWindow(i11, window, z11, 0L);
    }

    public abstract Window getWindow(int i11, Window window, boolean z11, long j11);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i11, Period period, Window window, int i12, boolean z11) {
        return getNextPeriodIndex(i11, period, window, i12, z11) == -1;
    }
}

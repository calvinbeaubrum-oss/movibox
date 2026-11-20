package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class WavHeader implements SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    public WavHeader(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.numChannels = i11;
        this.sampleRateHz = i12;
        this.averageBytesPerSecond = i13;
        this.blockAlignment = i14;
        this.bitsPerSample = i15;
        this.encoding = i16;
    }

    public final int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public final int getBytesPerFrame() {
        return this.blockAlignment;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return ((this.dataSize / ((long) this.blockAlignment)) * 1000000) / ((long) this.sampleRateHz);
    }

    public final int getEncoding() {
        return this.encoding;
    }

    public final int getNumChannels() {
        return this.numChannels;
    }

    public final int getSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j11) {
        long j12 = (((long) this.averageBytesPerSecond) * j11) / 1000000;
        int i11 = this.blockAlignment;
        long jConstrainValue = Util.constrainValue((j12 / ((long) i11)) * ((long) i11), 0L, this.dataSize - ((long) i11));
        long j13 = this.dataStartPosition + jConstrainValue;
        long timeUs = getTimeUs(j13);
        SeekPoint seekPoint = new SeekPoint(timeUs, j13);
        if (timeUs < j11) {
            long j14 = this.dataSize;
            int i12 = this.blockAlignment;
            if (jConstrainValue != j14 - ((long) i12)) {
                long j15 = j13 + ((long) i12);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j15), j15));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public final long getTimeUs(long j11) {
        return (Math.max(0L, j11 - this.dataStartPosition) * 1000000) / ((long) this.averageBytesPerSecond);
    }

    public final boolean hasDataBounds() {
        return (this.dataStartPosition == 0 || this.dataSize == 0) ? false : true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }

    public final void setDataBounds(long j11, long j12) {
        this.dataStartPosition = j11;
        this.dataSize = j12;
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j11, long j12, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j12;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j11 == -1) {
            this.dataSize = -1L;
            this.durationUs = C.TIME_UNSET;
        } else {
            this.dataSize = j11 - j12;
            this.durationUs = getTimeUs(j11);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j11) {
        long j12 = this.dataSize;
        if (j12 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.firstFramePosition));
        }
        long j13 = (((long) this.bitrate) * j11) / 8000000;
        int i11 = this.frameSize;
        long jConstrainValue = Util.constrainValue((j13 / ((long) i11)) * ((long) i11), 0L, j12 - ((long) i11));
        long j14 = this.firstFramePosition + jConstrainValue;
        long timeUs = getTimeUs(j14);
        SeekPoint seekPoint = new SeekPoint(timeUs, j14);
        if (timeUs < j11) {
            long j15 = this.dataSize;
            int i12 = this.frameSize;
            if (jConstrainValue != j15 - ((long) i12)) {
                long j16 = j14 + ((long) i12);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j16), j16));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public final long getTimeUs(long j11) {
        return (Math.max(0L, j11 - this.firstFramePosition) * 8000000) / ((long) this.bitrate);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return this.dataSize != -1;
    }
}

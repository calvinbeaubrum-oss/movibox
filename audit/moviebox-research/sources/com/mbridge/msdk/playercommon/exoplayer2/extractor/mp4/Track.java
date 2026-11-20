package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.Format;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE = 0;
    public final long durationUs;
    public final long[] editListDurations;
    public final long[] editListMediaTimes;
    public final Format format;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f46515id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    /* JADX INFO: compiled from: source.java */
    public @interface Transformation {
    }

    public Track(int i11, int i12, long j11, long j12, long j13, Format format, int i13, TrackEncryptionBox[] trackEncryptionBoxArr, int i14, long[] jArr, long[] jArr2) {
        this.f46515id = i11;
        this.type = i12;
        this.timescale = j11;
        this.movieTimescale = j12;
        this.durationUs = j13;
        this.format = format;
        this.sampleTransformation = i13;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i14;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public final TrackEncryptionBox getSampleDescriptionEncryptionBox(int i11) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i11];
    }
}

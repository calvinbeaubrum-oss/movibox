package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface TsPayloadReader {

    /* JADX INFO: compiled from: source.java */
    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i11, byte[] bArr) {
            this.language = str;
            this.type = i11;
            this.initializationData = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        public EsInfo(int i11, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            this.streamType = i11;
            this.language = str;
            this.dvbSubtitleInfos = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.descriptorBytes = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int i11, EsInfo esInfo);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i11, int i12) {
            this(Integer.MIN_VALUE, i11, i12);
        }

        public TrackIdGenerator(int i11, int i12, int i13) {
            String str;
            if (i11 != Integer.MIN_VALUE) {
                str = i11 + "/";
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i12;
            this.trackIdIncrement = i13;
            this.trackId = Integer.MIN_VALUE;
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public final void generateNewId() {
            int i11 = this.trackId;
            this.trackId = i11 == Integer.MIN_VALUE ? this.firstTrackId : i11 + this.trackIdIncrement;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public final String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        public final int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }
    }

    void consume(ParsableByteArray parsableByteArray, boolean z11) throws ParserException;

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();
}

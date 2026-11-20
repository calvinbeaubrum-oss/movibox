package com.mbridge.msdk.playercommon.exoplayer2.source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface SequenceableLoader {

    /* JADX INFO: compiled from: source.java */
    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t11);
    }

    boolean continueLoading(long j11);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    void reevaluateBuffer(long j11);
}

package com.google.android.exoplayer2.source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface q {

    /* JADX INFO: compiled from: source.java */
    public interface a<T extends q> {
        void g(T t11);
    }

    boolean continueLoading(long j11);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j11);
}

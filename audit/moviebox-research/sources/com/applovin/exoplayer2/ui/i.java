package com.applovin.exoplayer2.ui;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface i {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(i iVar, long j11);

        void a(i iVar, long j11, boolean z11);

        void b(i iVar, long j11);
    }

    void a(a aVar);

    void a(long[] jArr, boolean[] zArr, int i11);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j11);

    void setDuration(long j11);

    void setEnabled(boolean z11);

    void setPosition(long j11);
}

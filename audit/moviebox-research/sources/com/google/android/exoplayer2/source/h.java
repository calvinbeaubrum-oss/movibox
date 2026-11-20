package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b3;
import java.io.IOException;
import nh.d0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface h extends q {

    /* JADX INFO: compiled from: source.java */
    public interface a extends q.a<h> {
        void h(h hVar);
    }

    long a(long j11, b3 b3Var);

    @Override // com.google.android.exoplayer2.source.q
    boolean continueLoading(long j11);

    void discardBuffer(long j11, boolean z11);

    long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11);

    void f(a aVar, long j11);

    @Override // com.google.android.exoplayer2.source.q
    long getBufferedPositionUs();

    @Override // com.google.android.exoplayer2.source.q
    long getNextLoadPositionUs();

    k0 getTrackGroups();

    @Override // com.google.android.exoplayer2.source.q
    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    long readDiscontinuity();

    @Override // com.google.android.exoplayer2.source.q
    void reevaluateBuffer(long j11);

    long seekToUs(long j11);
}

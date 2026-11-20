package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.w1;
import java.io.IOException;
import p4.e0;
import p4.k0;
import s4.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface k extends t {

    /* JADX INFO: compiled from: source.java */
    public interface a extends t.a<k> {
        void f(k kVar);
    }

    @Override // androidx.media3.exoplayer.source.t
    boolean a(w1 w1Var);

    long b(long j11, b3 b3Var);

    void discardBuffer(long j11, boolean z11);

    long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11);

    void g(a aVar, long j11);

    @Override // androidx.media3.exoplayer.source.t
    long getBufferedPositionUs();

    @Override // androidx.media3.exoplayer.source.t
    long getNextLoadPositionUs();

    k0 getTrackGroups();

    @Override // androidx.media3.exoplayer.source.t
    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    long readDiscontinuity();

    @Override // androidx.media3.exoplayer.source.t
    void reevaluateBuffer(long j11);

    long seekToUs(long j11);
}

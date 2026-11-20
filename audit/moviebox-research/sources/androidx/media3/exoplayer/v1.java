package androidx.media3.exoplayer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v1 {
    boolean a(long j11, long j12, float f11);

    void b(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, w2[] w2VarArr, p4.k0 k0Var, s4.z[] zVarArr);

    boolean c(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, long j11, float f11, boolean z11, long j12);

    androidx.media3.exoplayer.upstream.b getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    boolean retainBackBufferFromKeyframe();
}

package com.google.android.exoplayer2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface s1 {
    boolean a(long j11, long j12, float f11);

    boolean b(long j11, float f11, boolean z11, long j12);

    void c(w2[] w2VarArr, nh.k0 k0Var, fi.s[] sVarArr);

    com.google.android.exoplayer2.upstream.b getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    boolean retainBackBufferFromKeyframe();
}

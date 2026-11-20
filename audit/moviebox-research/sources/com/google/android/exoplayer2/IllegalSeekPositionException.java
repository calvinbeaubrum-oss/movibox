package com.google.android.exoplayer2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final j3 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(j3 j3Var, int i11, long j11) {
        this.timeline = j3Var;
        this.windowIndex = i11;
        this.positionMs = j11;
    }
}

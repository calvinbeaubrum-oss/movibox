package androidx.media3.common;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final m0 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(m0 m0Var, int i11, long j11) {
        this.timeline = m0Var;
        this.windowIndex = i11;
        this.positionMs = j11;
    }
}
